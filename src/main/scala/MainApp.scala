import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.streaming.kafka010._
import org.apache.spark.streaming.kafka010.LocationStrategies.PreferConsistent
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.kafka010.ConsumerStrategies.Subscribe
import com.datastax.spark.connector._
import producers.Producer
import com.typesafe.config.ConfigFactory.load
import models.Stock

import scala.collection.JavaConverters._

class MainApp {
  Logger.getLogger("org").setLevel(Level.ERROR)

  private val sparkAppName = load().getString("StockStreaming.SparkConfiguration.appName")
  private val sparkMaster = load().getString("StockStreaming.SparkConfiguration.master")
  private val cassandraHost = load().getString("StockStreaming.CassandraConfiguration.cassandraHost")
  private val cassandraUsername = load().getString("StockStreaming.CassandraConfiguration.cassandraUsername")
  private val cassandraPassword = load().getString("StockStreaming.CassandraConfiguration.cassandraPassword")
  private val topics = load().getStringList("StockStreaming.KafkaConfiguration.topics").asScala

  private val kafkaParam = Map[String, Object](
    "bootstrap.servers" -> load().getString("StockStreaming.KafkaConfiguration.bootstrapServer"),
    "key.deserializer" -> classOf[StringDeserializer],
    "value.deserializer" -> classOf[StringDeserializer],
    "group.id" -> "use_a_separate_group_id_for_each_stream",
    "auto.offset.reset" -> "latest",
    "enable.auto.commit" -> (true: java.lang.Boolean)
  )

  private val sparkConf = new SparkConf()
    .setAppName(sparkAppName)
    .setMaster(sparkMaster)
    .set("spark.cassandra.connection.host", cassandraHost)
    .set("spark.cassandra.auth.username", cassandraUsername)
    .set("spark.cassandra.auth.password", cassandraPassword)
}

object MainApp extends App {
  private val keyspaceName = load().getString("StockStreaming.CassandraConfiguration.cassandraKeyspace")
  private val tableName = load().getString("StockStreaming.CassandraConfiguration.cassandraTable")
  private val conf = new MainApp()

  private val spark = SparkSession.builder()
    .config(conf.sparkConf)
    .getOrCreate()

  private val ssc = new StreamingContext(spark.sparkContext, Seconds(1))

  private val stream = KafkaUtils.createDirectStream[String, String](
    ssc,
    PreferConsistent,
    Subscribe[String, String](conf.topics, conf.kafkaParam))

  stream.map(r => r.value().toString)
    .map(new Stock().parseStock)
    .foreachRDD { rdd =>
      rdd.saveToCassandra(keyspaceName, tableName)
    }

  ssc.start()

  new Producer().simulateDataFlow(conf.topics(0))

  ssc.stop(true, true)
  ssc.awaitTermination()

}
