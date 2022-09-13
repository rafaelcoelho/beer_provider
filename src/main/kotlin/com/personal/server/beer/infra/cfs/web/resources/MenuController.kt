package com.personal.server.beer.infra.cfs.web.resources

import com.personal.server.beer.domain.service.ApplicationOrderService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RequestMapping("/menu/v1")
@RestController
class MenuController(val appService: ApplicationOrderService) {

    @PostMapping("/beer")
    fun newBeerToStock(@RequestBody beerDto: BeerDto): ResponseEntity<Any> {
        appService.newBeerOnStock(beerDto.many, beerDto.brand + UUID.randomUUID())
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

}

data class BeerDto(val many: Int, val brand: String)
