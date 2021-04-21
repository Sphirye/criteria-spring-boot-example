package com.sphiryecode.criteria.service

import com.sphiryecode.criteria.entity.Post
import com.sphiryecode.criteria.repository.PostRepository
import com.sphiryecode.criteria.repository.criteria.PostCriteria
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class PostService {

    @Autowired lateinit var postRepository: PostRepository
    @Autowired lateinit var postCriteria: PostCriteria

    fun init() {
        if (postRepository.count() <= 0) {
            for (i in 1..10) {
                val post = Post(title = ("Post $i"))
                postRepository.save(post)
            }
        }
    }

    fun create(title: String): Post {
        if (title.isBlank()) { throw IllegalArgumentException() }

        val post = Post(title = title)

        return postRepository.save(post)
    }

    fun findFilterPageable(page: Int, size: Int, search: String?): Page<Post> {
        return postCriteria.findFilterPageable(page, size, search)
    }
}
