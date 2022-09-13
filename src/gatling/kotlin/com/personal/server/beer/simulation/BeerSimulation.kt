package com.personal.server.beer.simulation

import io.gatling.javaapi.core.CoreDsl.*
import io.gatling.javaapi.core.Simulation
import io.gatling.javaapi.http.HttpDsl.http
import io.gatling.javaapi.http.HttpDsl.status
import java.util.*

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
                .check(status().`is`(200))
        )

    val scn_order_beer = scenario("OrderBeer")
        .exec(
            http("orderBeer")
                .post("/order/v1/beer")
                .body(
                    StringBody(
                        """
                    {
                      "volume": 10,
                      "qtd": 10,
                      "brand": "zalaz"
                    }
                """.trimIndent()
                    )
                )
                .check(status().`is`(200))
        )

    val scn_new_beer = scenario("NewBeerToMenu")
        .exec(
            http("AddBeer")
                .post("/menu/v1/beer")
                .body(
                    StringBody(
                        """
                    {
                      "many": 20,
                      "brand": "${UUID.randomUUID()}"
                    }
                """.trimIndent()
                    )
                )
                .check(status().`is`(201))
        )
}
