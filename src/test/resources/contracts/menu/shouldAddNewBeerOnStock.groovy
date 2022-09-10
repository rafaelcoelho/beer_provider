package contracts.menu

import org.springframework.cloud.contract.spec.Contract
import org.springframework.http.HttpStatus

[Contract.make {
    description("""
            Represents a successful scenario to add a new beer on the stock
            
            ```
                given:
                    beer provider is add a new beer in menu
                when:
                    he applies order to add new one
                then:
                    we'll grant that the beer will be available from menu
            ```
""")
    request {
        method 'POST'
        url '/menu/v1/beer'
        headers {
            contentType(applicationJson())
        }
        body("""
            {
              "many": 22,
              "brand": "Heineken"
            }
        """)
    }
    response {
        status HttpStatus.CREATED.value()
    }
}]
