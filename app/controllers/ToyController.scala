package controllers

import model.{Toy, ToyTable}
import play.api.mvc.{Action, Controller}
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.Future

/**
  * Created by wenjuntan on 2017-03-07.
  */
object ToyController extends Controller{

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



}
