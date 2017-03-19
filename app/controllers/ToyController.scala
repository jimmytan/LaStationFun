package controllers

import javax.inject.{Inject, Singleton}

import scala.concurrent.ExecutionContext.Implicits.global
import model.{Toy, ToyTable}
import play.api.libs.json._
import play.api.mvc.{Action, Controller}
import slick.jdbc.PostgresProfile.api._
import play.api.libs.functional.syntax._

import scala.collection.mutable.ArrayBuffer
import scala.concurrent.Future

/**
  * Created by wenjuntan on 2017-03-07.
  */
@Singleton
class ToyController @Inject() extends Controller{

  implicit val toyRead: Reads[Toy] = (
    (JsPath \ "id").read[Long] and
      (JsPath \ "code").read[String] and
      (JsPath \ "name").read[String] and
      (JsPath \ "price").read[Double] and
      (JsPath \ "priceUnit").read[String] and
      (JsPath \ "deposit").read[Double] and
      (JsPath \ "note").read[String]
  )(Toy.apply _)

  implicit val toyWrite: Writes[Toy] = (
    (JsPath \ "id").write[Long] and
      (JsPath \ "code").write[String] and
      (JsPath \ "name").write[String] and
      (JsPath \ "price").write[Double] and
      (JsPath \ "priceUnit").write[String] and
      (JsPath \ "deposit").write[Double] and
      (JsPath \ "note").write[String]
    )(unlift(Toy.unapply))


  val db = Database.forConfig("lafundb")
  val toys = TableQuery[ToyTable]

  def list = Action.async{
    val toySelect: DBIO[Seq[Toy]] = toys.result
    val toyFuture: Future[Seq[Toy]] = db.run(toySelect)
    toyFuture.map(toys => Ok(Json.toJson(toys)))
    
  }

  def show(code: String) = Action{
    Ok("Your new application is ready.")
  }

  def create = Action(parse.json){  request =>
    val toyJson = request.body
    val toy = toyJson.as[Toy]
    val insert = toys += toy
    val result = db.run(insert)
    Ok("new toy is created ")
  }

  def update(code: String) = Action{
    Ok("Your new application is ready.")
  }



}
