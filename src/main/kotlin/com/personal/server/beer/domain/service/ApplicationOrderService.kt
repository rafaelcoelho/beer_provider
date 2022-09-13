package com.personal.server.beer.domain.service

import com.personal.server.beer.domain.model.Beer
import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentHashMap

@Service
class ApplicationOrderService {
    private val beersStock: ConcurrentHashMap<String, Int> = ConcurrentHashMap()

    init {
        beersStock["patagonia"] = 10
        beersStock["zalaz"] = 11
        beersStock["b&d"] = 9
        beersStock["3#Orelhas"] = 15
    }

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
