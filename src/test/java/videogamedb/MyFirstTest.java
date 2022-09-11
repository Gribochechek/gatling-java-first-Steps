package videogamedb;


import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.core.CoreDsl.atOnceUsers;
import static io.gatling.javaapi.core.CoreDsl.scenario;
import static io.gatling.javaapi.http.HttpDsl.http;


public class MyFirstTest extends Simulation {


    // 1 Http Configuration

    HttpProtocolBuilder httpProtocol = http.baseUrl("https://pocketbook.ua/")
            .acceptHeader("application/json");






    // 2 Scenario Definition

    ScenarioBuilder users = scenario("My First Test")
            .exec(http("Get main Page")
                    .get("/"));




    // 3 Load Scenarion


    {
        setUp(
                users.injectOpen(atOnceUsers(100))
        ).protocols(httpProtocol);
    }
}
