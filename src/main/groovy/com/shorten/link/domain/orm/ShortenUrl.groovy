package com.shorten.link.domain.orm

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
class ShortenUrl extends Timestampable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    String name

    String title

    String url

    String newUrl

    Boolean active
}
