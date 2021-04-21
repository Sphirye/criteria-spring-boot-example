package com.sphiryecode.criteria.entity

import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Post (
    @Id @GeneratedValue
    var id: Long? = null,

    var title: String? = null
): Serializable