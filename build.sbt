name := "StockStreaming"

version := "0.1"

scalaVersion := "2.11.12"

libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.2.0"
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.2.0"
libraryDependencies += "org.apache.spark" %% "spark-streaming-kafka-0-10" % "2.2.0"
libraryDependencies += "org.apache.spark" %% "spark-streaming" % "2.2.0"
libraryDependencies += "com.datastax.spark" %% "spark-cassandra-connector" % "2.0.7"
libraryDependencies += "com.typesafe" % "config" % "1.3.3"