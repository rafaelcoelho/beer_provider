package com.personal.server.beer.infra.cfs.web.resources

import com.personal.server.beer.domain.model.Beer
import com.personal.server.beer.domain.service.ApplicationOrderService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive

@RequestMapping("/order/v1")
@RestController
class BeerController(val appService: ApplicationOrderService) {

    @PostMapping("/beer")
    fun orderABeer(@RequestBody @Valid req: OrderRequest): Beer {
        return appService.orderBeer(req.qtd, req.volume, req.brand)
    }

    @GetMapping("/beer")
    fun list(): List<Beer> {
        return appService.list()
    }
}

data class OrderRequest(
    @field:Positive
    val volume: Int,
    @field:Positive
    val qtd: Int,
    @field:NotBlank
    val brand: String
)
