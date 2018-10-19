name := "scalaLearn"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies +=
  "com.typesafe.akka" %% "akka-actor" % "2.4.17"

libraryDependencies += "joda-time" % "joda-time" % "2.1"

libraryDependencies += "info.folone" %% "poi-scala" % "0.18"

libraryDependencies += "org.mongodb" %% "casbah" % "3.1.1"

libraryDependencies += "org.json4s" % "json4s-jackson_2.12" % "3.5.3"

libraryDependencies += "org.mongodb" % "mongodb-driver" % "3.5.0"

libraryDependencies ++= Seq(
	"org.scalikejdbc" %% "scalikejdbc"       % "3.1.0",
	"mysql" % "mysql-connector-java" % "6.0.6",
	"ch.qos.logback"  %  "logback-classic"   % "1.2.3"
)

libraryDependencies += "org.apache.commons" % "commons-lang3" % "3.0"

libraryDependencies += "com.google.guava" % "guava" % "23.0"

libraryDependencies += "com.typesafe.play" % "play-json_2.11" % "2.6.3"

libraryDependencies += "com.alibaba" % "fastjson" % "1.2.46"

libraryDependencies += "com.google.code.gson" % "gson" % "2.8.2"

libraryDependencies += "org.springframework.boot" % "spring-boot-starter-data-mongodb" % "1.5.3.RELEASE"

libraryDependencies += "com.gingersoftware" % "object-csv_2.11" % "0.3"

libraryDependencies += "org.apache.commons" % "commons-lang3" % "3.7"

libraryDependencies += "org.projectlombok" % "lombok" % "1.16.18" % "provided"

libraryDependencies += "cglib" % "cglib" % "3.2.6"
