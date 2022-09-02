package com.personal.server.beer

import io.restassured.module.mockmvc.RestAssuredMockMvc
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.web.context.WebApplicationContext

@SpringBootTest
abstract class BeerOrderManagementBaseTest {

    @Autowired
    internal var webApplicationContext: WebApplicationContext? = null

    @BeforeEach
    fun setup() {
        RestAssuredMockMvc.webAppContextSetup(this.webApplicationContext)
    }
}
