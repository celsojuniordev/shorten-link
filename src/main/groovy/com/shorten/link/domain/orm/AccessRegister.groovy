package com.shorten.link.domain.orm

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

import javax.persistence.*

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
class AccessRegister {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    Integer clicks

    Date lastAccess

    @ManyToOne(fetch = FetchType.LAZY)
    ShortenUrl shortenUrl

}
