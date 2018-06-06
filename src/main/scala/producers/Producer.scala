package producers

import java.util.Properties
import com.typesafe.config.ConfigFactory.load
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import utils.utils
import scala.io.Source

class Producer {

  private val properties = new Properties()
  properties.put("bootstrap.servers", load().getString("StockStreaming.KafkaConfiguration.bootstrapServer"))
  properties.put("client.id", "StockProducer")
  properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

  private val files = new utils().getListOfFiles(load().getString("StockStreaming.DataConfiguration.dataPath"))
  private val producer = new KafkaProducer[String, String](properties)

  def simulateDataFlow(topic: String): Unit = {
    for (file <- files.par) {
      val filename = Source.fromFile(file)
      for (line <- filename.getLines().drop(1)) {
        val data = new ProducerRecord[String, String](topic, line.concat("," + file.getName.replace(".txt", "")))
        producer.send(data)
      }
      filename.close()
    }
    producer.close()
  }
}
