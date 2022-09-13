package com.personal.server.beer.simulation

import io.gatling.javaapi.core.CoreDsl.StringBody
import io.gatling.javaapi.core.CoreDsl.scenario
import io.gatling.javaapi.core.Simulation
import io.gatling.javaapi.http.HttpDsl.http

class BeerSimulation : Simulation() {
    val httpProtocol = http
        .baseUrl("http://localhost:8080")
        .acceptHeader("*/*")
        .contentTypeHeader("application/json")
        .userAgentHeader("Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0")

    val scn_list_beer = scenario("BeersMenu")
        .exec(
            http("listMenu")
                .get("/order/v1/beer")
        )

    val scn_order_beer = scenario("OrderBeer")
        .exec(
            http("orderBeer")
                .post("/order/v1/beer")
                .body(
                    StringBody(
                        """
                    
                """.trimIndent()
                    )
                )
        )
}
