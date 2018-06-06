# StockStreaming

Requirements: <br>
Java 8 <br>
Kafka 1.0.1 <br>
Data: https://www.kaggle.com/borismarjanovic/price-volume-data-for-all-us-stocks-etfs <br>
Scala 2.11 <br>
Spark 2.2<br>
Cassandra DB <br><br>

Configure: <br>
Cassandra db => ip, user, pass<br>
Checkpoint path<br>
Kafka bootstrap server<br>
Data files location (producer class)<br><br>

Simulate stock streaming from files trough Kafka => SparkStreaming => Cassandra DB
