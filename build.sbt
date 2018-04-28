name := "tp5"
 
version := "1.0" 
      
lazy val `tp5` = (project in file(".")).enablePlugins(PlayJava)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
scalaVersion := "2.11.11"

libraryDependencies ++= Seq( javaJdbc , cache , javaWs)

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )

libraryDependencies += "com.amazonaws" % "aws-java-sdk" % "1.11.145"


// https://mvnrepository.com/artifact/org.json/json
libraryDependencies += "org.json" % "json" % "20180130"

