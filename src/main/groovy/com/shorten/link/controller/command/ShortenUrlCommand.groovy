package com.shorten.link.controller.command

import com.shorten.link.domain.orm.ShortenUrl
import lombok.Data

@Data
class ShortenUrlCommand {

    String name

    String title

    String url

    String newUrl

    Boolean active

    def bindData(ShortenUrl shortenUrl) {
        shortenUrl.name = this.name
        shortenUrl.title = this.title
        shortenUrl.url = this.url
        shortenUrl.newUrl = this.newUrl
        shortenUrl.active = this.active
    }
}
