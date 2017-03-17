package controllers

import model.{Toy, ToyTable}
import play.api.libs.json._
import play.api.mvc.{Action, Controller}
import slick.jdbc.PostgresProfile.api._
import play.api.libs.functional.syntax._

import scala.concurrent.Future

/**
  * Created by wenjuntan on 2017-03-07.
  */
object ToyController extends Controller{

  implicit val toyRead: Reads[Toy] = (
    (JsPath \ "id").read[Long] and
      (JsPath \ "code").read[String] and
      (JsPath \ "name").read[String] and
      (JsPath \ "price").read[Double] and
      (JsPath \ "priceUnit").read[String] and
      (JsPath \ "deposit").read[Double] and
      (JsPath \ "note").read[String]
  )(Toy.apply _)


  private val db = Database.forConfig("db")


  def index = Action{
    lazy val toys = TableQuery[ToyTable]
    val toySelect: DBIO[Seq[Toy]] = toys.result
    val toyFuture: Future[Seq[Toy]] = db.run(toySelect)
    Ok("Your new application is ready.")
  }


  def list = Action{

    Ok("Your new application is ready.")
  }

  def show = Action{
    Ok("Your new application is ready.")
  }

  def create = Action(parse.json){
    
    Ok("Your new application is ready.")
  }



}
