package com.shorten.link.controller

import com.shorten.link.controller.command.ShortenUrlCommand
import com.shorten.link.domain.orm.ShortenUrl
import com.shorten.link.service.ShortenUrlService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/")
class ShortenUrlController {

    @Autowired
    ShortenUrlService service

    @PostMapping("shortenUrl")
    ResponseEntity<ShortenUrl> save(@RequestBody ShortenUrlCommand shortenUrlCommand) {

        ShortenUrl shortenUrl = new ShortenUrl()
        shortenUrlCommand.bindData(shortenUrl)
        service.save(shortenUrl)

        ResponseEntity.ok(shortenUrl)
    }

    @GetMapping("a/{name}")
    ResponseEntity<Object> redirectToNewUrl(@PathVariable("name") String name) throws URISyntaxException {
        String foundOriginalUrl = service.findOriginalUrlByName(name)
        URI originalUrl = new URI(foundOriginalUrl)
        HttpHeaders httpHeaders = new HttpHeaders()
        httpHeaders.setLocation(originalUrl)
        return new ResponseEntity<>(httpHeaders, HttpStatus.MOVED_PERMANENTLY)
    }

}
