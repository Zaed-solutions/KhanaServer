package org.khana.khanaserver.controller

import org.khana.khanaserver.data.response.GenericResponse
import org.khana.khanaserver.service.AdvertisementService
import org.khana.khanaserver.service.model.AdvertisementDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController("/advertisements")
class AdvertisementController(
    val advertisementService: AdvertisementService
) {
    @GetMapping("/all")
    fun getAdvertisements() = GenericResponse(
        200,
        "Success",
        advertisementService.getAll()
    )
    @PostMapping("/insert")
    fun insertAdvertisement(@RequestBody advertisement :AdvertisementDto) :GenericResponse<Unit>{
        advertisementService.insertOne(advertisement)
        return GenericResponse(code=200, message = "Success")
    }

}