package model

import slick.jdbc.PostgresProfile.api._
/**
  * Created by wenjuntan on 2017-03-08.
  */
final case class Toy(
  id: Long = 0,
  code: String,
  name: String,
  price: Double,
  priceUnit: String,
  deposit: Double,
  Note: String)

final class ToyTable(tag: Tag) extends Table[Toy](tag, "TOY"){

  def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
  def code = column[String]("code")
  def name = column[String]("name")
  def price = column[Double]("price")
  def priceUnit = column[String]("priceUnit")
  def deposit = column[Double]("deposit")
  def note = column[String]("note")

  def * = (id, code, name, price, priceUnit, deposit, note) <> (Toy.tupled, Toy.unapply)
}
