package models

import java.util.UUID

private [models] case class StockObj (id: UUID, stock_date: String, open: Double, high: Double, low: Double, close: Double, volume: Long, openint: Int, company_name: String)