package com.sphiryecode.criteria.controller

import com.sphiryecode.criteria.entity.Post
import com.sphiryecode.criteria.service.PostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class PostController {

    @Autowired lateinit var postService: PostService

    @GetMapping("/public/posts")
    fun getPosts(
        @RequestParam(required = false) title: String?,
        @RequestParam page: Int,    //Remember, in this case page 0 is actually page 1
        @RequestParam size: Int
    ): ResponseEntity<List<Post>> {
        val result = postService.findFilterPageable(page, size, title)
        return ResponseEntity.status(HttpStatus.OK).body(result.content)
    }

    @PostMapping("/public/posts")
    fun postPost(
        @RequestParam title: String
    ): ResponseEntity<Post> {
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.create(title))
    }

}