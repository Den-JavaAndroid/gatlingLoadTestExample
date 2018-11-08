package rest

import io.gatling.core.Predef._
import io.gatling.http.Predef._


package object RestMethods {
  private val header = Map("accept-encoding" -> "gzip, deflate",
    "Content-Type" -> "application/json;charset=UTF-8"
  );

  val httpProtocol = http
    .baseURL(TestSettings.restServiceUrl)
    .inferHtmlResources()
    .acceptEncodingHeader("gzip,deflate")
    .contentTypeHeader("text/xml;charset=UTF-8")
    .userAgentHeader("Apache-HttpClient/4.1.1 (java 1.5)")


  def firstGetRequest() =
    exec(http("getRequest")
      .get("planets/1/")
      .headers(header)
      .body(StringBody("")).asJSON
      //      .body(ElFileBody("src/test/requests_body/json/firstRequest.json")).asJSON  //useful for post requests
      .check(status.is(200))
      .check(jsonPath("$.name").is("Tatooine"))
    )

//  def firstPostRequest() =
//    exec(http("postRequest")
//      .post("planets")
//      .headers(header)
//      .body(ElFileBody("src/test/requests_body/json/firstRequest.json")).asJSON //useful for post requests
//      .check(status.is(200))
//    )


}
