package com.shorten.link.service

import com.shorten.link.domain.orm.ShortenUrl
import com.shorten.link.domain.repository.ShortenUrlRepository
import com.shorten.link.exception.NotFoundException
import com.shorten.link.exception.UnprocessableEntityException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ShortenUrlService {

    @Autowired
    ShortenUrlRepository shortenUrlRepository

    ShortenUrl save(ShortenUrl shortenUrl) {
        shortenUrl.name = shortenUrl.name ?: UUID.randomUUID().toString().split("-").first()
        shortenUrl.newUrl = "http://localhost:8080/" + shortenUrl.name

        if (shortenUrlRepository.countByName(shortenUrl.name)) {
            throw new UnprocessableEntityException("Já existe um link cadastrado com este nome.")
        }

        shortenUrlRepository.save(shortenUrl)
    }

    String findOriginalUrlByName(String name) {
        ShortenUrl shortenUrl = shortenUrlRepository.findByName(name)

        if (!shortenUrl) {
            throw new NotFoundException("Url não encontrada.")
        }

        shortenUrl.url
    }

}
