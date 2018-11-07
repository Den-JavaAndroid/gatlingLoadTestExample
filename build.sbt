name := "gatlingLoadTestExample"
/*
Подключаем плагин Gatling. Сам плагин должен быть указан в plugins.sbt
*/
enablePlugins(GatlingPlugin)

version := "0.1"

scalaVersion := "2.12.7"

libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.3.0"
libraryDependencies += "io.gatling"            % "gatling-test-framework"    % "2.3.0" % "test,it"
libraryDependencies += "io.gatling" %% "jsonpath" % "0.2"
