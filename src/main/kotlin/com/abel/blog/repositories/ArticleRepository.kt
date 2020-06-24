package com.abel.blog.repositories

import com.abel.blog.entities.Article
import org.springframework.data.repository.CrudRepository

interface ArticleRepository : CrudRepository<Article, Long> {
    fun findBySlug(slug: String) : Article?
    fun findAllByOrderByAddedAtDesc(): Iterable<Article>
}