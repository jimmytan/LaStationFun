package controllers

import play.api.mvc.{Action, Controller}

/**
  * Created by wenjuntan on 2017-03-07.
  */
object ToyController extends Controller{


  def index = Action{
    Ok("Your new application is ready.")
  }

}
