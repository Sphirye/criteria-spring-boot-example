package com.sphiryecode.criteria.repository.criteria

import org.springframework.data.domain.Page
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import com.sphiryecode.criteria.entity.Post
import com.sphiryecode.criteria.entity.Post_
import com.sphiryecode.criteria.service.tool.CriteriaTool
import javax.persistence.criteria.Path

@Repository
class PostCriteria {

    @PersistenceContext lateinit var entityManager: EntityManager

    fun findFilterPageable(page: Int, size: Int, search: String?): Page<Post> {
        val criteriaBuilder = entityManager.criteriaBuilder
        val query = criteriaBuilder.createQuery(Post::class.java)
        val post = query.from(Post::class.java)

        val order: Path<Set<String>> = post.get(Post_.ID)

        query.select(post).where().orderBy(criteriaBuilder.desc(order))

        return CriteriaTool.page(entityManager, query, page, size)

    }
}