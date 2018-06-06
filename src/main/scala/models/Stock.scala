package models
import com.datastax.driver.core.utils.UUIDs

class Stock extends Serializable {

  def parseStock(data: String): StockObj = {
    val splited = data.split(",")
    StockObj(id = UUIDs.random(),
      stock_date = splited(0),
      open = splited(1).toDouble,
      high = splited(2).toDouble,
      low = splited(3).toDouble,
      close = splited(4).toDouble,
      volume = splited(5).toLong,
      openint = splited(6).toInt,
      company_name = splited(7)
    )
  }
}
