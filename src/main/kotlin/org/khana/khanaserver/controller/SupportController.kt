package org.khana.khanaserver.controller

import org.khana.khanaserver.data.response.GenericResponse
import org.khana.khanaserver.service.SupportService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.khana.khanaserver.service.model.ContactInfoDto
import org.khana.khanaserver.service.model.FAQDto

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
    @GetMapping("/faqs")
    fun fetchFAQs() = GenericResponse(
        code = 200,
        message = "Success",
        data = supportService.fetchFAQs(),
    )
    @PostMapping("/insertFAQ")
    fun insertFAQ(@RequestBody faq: FAQDto) = GenericResponse(
        code = 200,
        message = "Success",
        data = supportService.insertFAQ(faq)
    )
}