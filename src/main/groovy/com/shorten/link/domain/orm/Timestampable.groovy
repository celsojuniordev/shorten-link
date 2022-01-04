package com.shorten.link.domain.orm

import javax.persistence.PrePersist
import javax.persistence.PreRemove
import javax.persistence.PreUpdate

abstract class Timestampable {

    Date dateCreated

    Date lastUpdated

    @PrePersist
    protected void prePersist() {
        dateCreated = new Date()
        lastUpdated = new Date()
    }

    @PreUpdate
    protected void preUpdate() {
        lastUpdated = new Date()
    }

}
