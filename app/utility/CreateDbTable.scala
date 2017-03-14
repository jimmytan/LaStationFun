package utility

import model.{Toy, ToyTable}
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.duration.Duration
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

/**
  * Created by wenjuntan on 2017-03-13.
  */
object CreateDbTable {

     def main(args: Array[String]): Unit = {
       val db = Database.forConfig("db")
       val toy = TableQuery[ToyTable]
       val setupAction: DBIO[Unit] = DBIO.seq(
         toy.schema.create
       )

       val setupFuture = db.run(setupAction)
       Await.result(setupFuture, 2000 seconds)
       println("done")
     }

}
