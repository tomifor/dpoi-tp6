
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/tomasforman/sandbox/dpoi/conf/routes
// @DATE:Fri Apr 27 12:44:21 ART 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
