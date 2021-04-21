package com.sphiryecode.criteria.config

import com.sphiryecode.criteria.service.PostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class PopulateConfig {

    @Autowired lateinit var postService: PostService

    @PostConstruct
    fun init () {
        postService.init()
    }

}