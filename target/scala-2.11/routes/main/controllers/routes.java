
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/tomasforman/sandbox/dpoi/conf/routes
// @DATE:Fri Apr 27 12:44:21 ART 2018

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseArticleController ArticleController = new controllers.ReverseArticleController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseApplication Application = new controllers.ReverseApplication(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseArticleController ArticleController = new controllers.javascript.ReverseArticleController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseApplication Application = new controllers.javascript.ReverseApplication(RoutesPrefix.byNamePrefix());
  }

}
