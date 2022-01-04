package com.shorten.link.domain.repository

import com.shorten.link.domain.orm.ShortenUrl
import org.springframework.data.jpa.repository.JpaRepository

interface ShortenUrlRepository extends JpaRepository<ShortenUrl, Long> {

    countByName(String name)

    ShortenUrl findByName(String name)
}