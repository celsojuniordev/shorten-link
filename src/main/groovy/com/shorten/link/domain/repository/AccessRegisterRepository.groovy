package com.shorten.link.domain.repository

import com.shorten.link.domain.orm.AccessRegister
import org.springframework.data.jpa.repository.JpaRepository

interface AccessRegisterRepository extends JpaRepository<AccessRegister, Long> {

}