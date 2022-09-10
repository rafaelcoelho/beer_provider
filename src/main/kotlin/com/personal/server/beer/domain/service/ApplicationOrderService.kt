package com.personal.server.beer.domain.service

import com.personal.server.beer.domain.model.Beer
import org.springframework.stereotype.Service

@Service
class ApplicationOrderService {
    private val beersStock = mutableMapOf(
        "patagonia" to 10,
        "zalaz" to 11,
        "b&d" to 9,
        "3#Orelhas" to 15
    )

    fun orderBeer(many: Int, volume: Int, brand: String): Beer {
        val availability = beersStock.getOrDefault(brand, 0)

        return Beer(volume, brand, availability)
    }

    fun list(): List<Beer> {
        val beers = mutableListOf<Beer>()

        beersStock.forEach { (k, u) -> beers.add(Beer(k.length, k, u)) }

        return beers
    }

    fun newBeerOnStock(many: Int, brand: String) {
        beersStock[brand] = many
    }
}
