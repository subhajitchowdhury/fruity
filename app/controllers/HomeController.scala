package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import scala.collection.immutable.TreeMap

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    println("Hello I'm in the index")
    val myResult = "This is the result I got from backend"
    val bestFootballers=Seq("Messi","Maradonna","Ronaldo","Zidane","Torres")
    val bestCricketers=Seq("Sachin","McGrath","Akram","Gilchrist","Donald")

    val myBoolean:Boolean   = false
    Ok(views.html.index(myResult,bestFootballers,bestCricketers,myBoolean))
  }

  def liverpoolfc() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.liverpoolfc())
  }

  def nufc()= Action {implicit request: Request[AnyContent]=>
    val nufcFivePlayers: TreeMap[String,String]= TreeMap("1" -> "Jamaal", "2" -> "Shelvey", "3" ->"Joselu","4"->"Perez","5" ->"Atsu")
    Ok(views.html.nufc(nufcFivePlayers))
  }
}
