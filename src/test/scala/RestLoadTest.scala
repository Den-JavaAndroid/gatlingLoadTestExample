import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import rest.RestMethods


class RestLoadTest extends Simulation{

  before{
    println("Start load test for url " + TestSettings.restServiceUrl)
  }
  after {
    println("End load test for url: " + TestSettings.restServiceUrl)
  }

  //complete scenario
  val firstScenario  = scenario("firstScenario")
    .exec(RestMethods.firstGetRequest())
//    .exec(RestMethods.firstPostRequest())

  //execute scenario
  setUp(
    firstScenario.inject(
//      rampUsers(1) over(1)
      atOnceUsers(1)

      //see all options here https://gatling.io/docs/2.2/general/simulation_setup/

    ).protocols(RestMethods.httpProtocol)
  )



}
