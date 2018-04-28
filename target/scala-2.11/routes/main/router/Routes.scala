
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/tomasforman/sandbox/dpoi/conf/routes
// @DATE:Fri Apr 27 12:44:21 ART 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  Application_1: controllers.Application,
  // @LINE:9
  Assets_0: controllers.Assets,
  // @LINE:11
  ArticleController_2: controllers.ArticleController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    Application_1: controllers.Application,
    // @LINE:9
    Assets_0: controllers.Assets,
    // @LINE:11
    ArticleController_2: controllers.ArticleController
  ) = this(errorHandler, Application_1, Assets_0, ArticleController_2, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Application_1, Assets_0, ArticleController_2, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.Application.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """articles""", """controllers.ArticleController.getAllArticles"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """articles/""" + "$" + """id<[^/]+>""", """controllers.ArticleController.getArticle(id:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_Application_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_Application_index0_invoker = createInvoker(
    Application_1.index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "index",
      Nil,
      "GET",
      """ Home page""",
      this.prefix + """"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_Assets_at1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at1_invoker = createInvoker(
    Assets_0.at(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/""" + "$" + """file<.+>"""
    )
  )

  // @LINE:11
  private[this] lazy val controllers_ArticleController_getAllArticles2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("articles")))
  )
  private[this] lazy val controllers_ArticleController_getAllArticles2_invoker = createInvoker(
    ArticleController_2.getAllArticles,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ArticleController",
      "getAllArticles",
      Nil,
      "GET",
      """""",
      this.prefix + """articles"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_ArticleController_getArticle3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("articles/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ArticleController_getArticle3_invoker = createInvoker(
    ArticleController_2.getArticle(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ArticleController",
      "getArticle",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """articles/""" + "$" + """id<[^/]+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_Application_index0_route(params) =>
      call { 
        controllers_Application_index0_invoker.call(Application_1.index)
      }
  
    // @LINE:9
    case controllers_Assets_at1_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at1_invoker.call(Assets_0.at(path, file))
      }
  
    // @LINE:11
    case controllers_ArticleController_getAllArticles2_route(params) =>
      call { 
        controllers_ArticleController_getAllArticles2_invoker.call(ArticleController_2.getAllArticles)
      }
  
    // @LINE:12
    case controllers_ArticleController_getArticle3_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_ArticleController_getArticle3_invoker.call(ArticleController_2.getArticle(id))
      }
  }
}
