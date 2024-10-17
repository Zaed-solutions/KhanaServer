package org.khana.khanaserver.controller

import org.khana.khanaserver.data.response.GenericResponse
import org.khana.khanaserver.service.SupportService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.zaed.khana.data.model.ContactInfoDto

@RestController
@RequestMapping("/support")
class SupportController(
    private val supportService: SupportService
) {
    @GetMapping("/contactInfo")
    fun fetchContactInfo() = GenericResponse(
        code = 200,
        message = "Success",
        data = supportService.fetchContactInfo(),
    )
    @PostMapping("/insertContactInfo")
    fun insertContactInfo(@RequestBody contactInfo: ContactInfoDto) = GenericResponse(
        code = 200,
        message = "Success",
        data = supportService.insertContactInfo(contactInfo)
    )
}