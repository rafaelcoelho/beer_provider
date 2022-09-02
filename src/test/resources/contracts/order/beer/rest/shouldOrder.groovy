package contracts.order.beer.rest

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("""
            Represents a successful scenario of list the beer menu
            
            ```
                given:
                    client is browsing menu
                when:
                    he applies ask for beers options
                then:
                    we'll grant the list of beers available
            ```
        """)
    request {
        method 'GET'
        url '/order/v1/beer'
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status 200
        headers {
            contentType(applicationJson())
        }
        bodyMatchers {
            jsonPath('$', byType {
                minOccurrence(4)
            })
        }
    }
}
