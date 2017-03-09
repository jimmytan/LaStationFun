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

}
