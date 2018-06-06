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


Stats [ Single machine 4-core, 1 cassandra node, 1 kafka broker] :
18/06/06 11:43:29 INFO TableWriter: Wrote 140827 rows to stockstreaming.stock_data in 40,785 s.
18/06/06 11:44:46 INFO TableWriter: Wrote 260054 rows to stockstreaming.stock_data in 77,200 s.
18/06/06 11:46:30 INFO TableWriter: Wrote 351520 rows to stockstreaming.stock_data in 104,083 s.
18/06/06 11:47:54 INFO TableWriter: Wrote 367322 rows to stockstreaming.stock_data in 84,319 s.
18/06/06 11:49:17 INFO TableWriter: Wrote 403566 rows to stockstreaming.stock_data in 82,921 s.
18/06/06 11:50:32 INFO TableWriter: Wrote 364941 rows to stockstreaming.stock_data in 74,301 s.
18/06/06 11:51:45 INFO TableWriter: Wrote 341812 rows to stockstreaming.stock_data in 72,891 s.
18/06/06 11:53:00 INFO TableWriter: Wrote 384209 rows to stockstreaming.stock_data in 75,179 s.
18/06/06 11:54:13 INFO TableWriter: Wrote 353241 rows to stockstreaming.stock_data in 72,981 s.
18/06/06 11:55:26 INFO TableWriter: Wrote 311773 rows to stockstreaming.stock_data in 72,946 s.
18/06/06 11:56:40 INFO TableWriter: Wrote 349238 rows to stockstreaming.stock_data in 74,361 s.
18/06/06 11:57:53 INFO TableWriter: Wrote 372879 rows to stockstreaming.stock_data in 72,781 s.
18/06/06 11:59:20 INFO TableWriter: Wrote 427974 rows to stockstreaming.stock_data in 87,187 s.
18/06/06 12:00:51 INFO TableWriter: Wrote 431839 rows to stockstreaming.stock_data in 90,793 s.
18/06/06 12:02:20 INFO TableWriter: Wrote 434294 rows to stockstreaming.stock_data in 88,762 s.
18/06/06 12:03:50 INFO TableWriter: Wrote 430573 rows to stockstreaming.stock_data in 90,494 s.
18/06/06 12:05:12 INFO TableWriter: Wrote 431983 rows to stockstreaming.stock_data in 82,044 s.
18/06/06 12:06:31 INFO TableWriter: Wrote 418540 rows to stockstreaming.stock_data in 79,063 s.
18/06/06 12:07:57 INFO TableWriter: Wrote 437202 rows to stockstreaming.stock_data in 85,781 s.
18/06/06 12:09:07 INFO TableWriter: Wrote 364449 rows to stockstreaming.stock_data in 69,852 s.
18/06/06 12:10:31 INFO TableWriter: Wrote 425126 rows to stockstreaming.stock_data in 83,701 s.
18/06/06 12:11:58 INFO TableWriter: Wrote 414667 rows to stockstreaming.stock_data in 87,215 s.
18/06/06 12:13:17 INFO TableWriter: Wrote 383237 rows to stockstreaming.stock_data in 79,372 s.
18/06/06 12:14:31 INFO TableWriter: Wrote 348525 rows to stockstreaming.stock_data in 73,528 s.
18/06/06 12:15:58 INFO TableWriter: Wrote 410173 rows to stockstreaming.stock_data in 86,842 s.
18/06/06 12:17:15 INFO TableWriter: Wrote 394999 rows to stockstreaming.stock_data in 77,515 s.
18/06/06 12:18:33 INFO TableWriter: Wrote 407551 rows to stockstreaming.stock_data in 77,935 s.
18/06/06 12:19:56 INFO TableWriter: Wrote 423766 rows to stockstreaming.stock_data in 82,328 s.
18/06/06 12:21:16 INFO TableWriter: Wrote 415231 rows to stockstreaming.stock_data in 80,088 s.
18/06/06 12:22:32 INFO TableWriter: Wrote 390450 rows to stockstreaming.stock_data in 75,938 s.
18/06/06 12:23:41 INFO TableWriter: Wrote 368698 rows to stockstreaming.stock_data in 69,465 s.
18/06/06 12:24:51 INFO TableWriter: Wrote 362347 rows to stockstreaming.stock_data in 69,547 s.
18/06/06 12:26:02 INFO TableWriter: Wrote 347995 rows to stockstreaming.stock_data in 71,257 s.
18/06/06 12:27:11 INFO TableWriter: Wrote 337615 rows to stockstreaming.stock_data in 69,264 s.
18/06/06 12:28:16 INFO TableWriter: Wrote 304798 rows to stockstreaming.stock_data in 64,245 s.
18/06/06 12:29:33 INFO TableWriter: Wrote 368582 rows to stockstreaming.stock_data in 77,481 s.
18/06/06 12:30:45 INFO TableWriter: Wrote 352752 rows to stockstreaming.stock_data in 71,697 s.
18/06/06 12:31:43 INFO TableWriter: Wrote 308909 rows to stockstreaming.stock_data in 58,001 s.
18/06/06 12:32:37 INFO TableWriter: Wrote 285798 rows to stockstreaming.stock_data in 54,385 s.
18/06/06 12:33:36 INFO TableWriter: Wrote 301561 rows to stockstreaming.stock_data in 58,952 s.
18/06/06 12:34:13 INFO TableWriter: Wrote 155414 rows to stockstreaming.stock_data in 37,193 s.
18/06/06 12:34:14 INFO TableWriter: Wrote 1235 rows to stockstreaming.stock_data in 0,208 s.

![alt text](https://i.imgur.com/NyfcXND.png)
