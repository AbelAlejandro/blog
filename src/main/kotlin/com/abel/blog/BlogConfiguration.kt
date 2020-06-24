package com.abel.blog

import com.abel.blog.entities.Article
import com.abel.blog.entities.User
import com.abel.blog.repositories.ArticleRepository
import com.abel.blog.repositories.UserRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BlogConfiguration {

    @Bean
    fun databaseInitializer(userRepository: UserRepository,
    articleRepository: ArticleRepository) = ApplicationRunner {
        val battaglia = userRepository.save(User("rbattaglia", "Roberto", "Battaglia"))
        articleRepository.save(Article(
                title = "Storia della resistenza italiana",
                headline = "A tanti anni di distanza, la lotta di liberazione si sottrae a qualsiasi facile schema celebrativo",
                content = "E difficile precisare in quale periodo esatto sia cominciata la crisi decisiva del regime fascista, quando cioe abbia avuto inizio...",
                author = battaglia
        ))
        articleRepository.save(Article(
                title = "Storia della resistenza italiana 2",
                headline = "A tanti anni di distanza, la lotta di liberazione si sottrae a qualsiasi facile schema celebrativo",
                content = "E difficile precisare in quale periodo esatto sia cominciata la crisi decisiva del regime fascista, quando cioe abbia avuto inizio...",
                author = battaglia
        ))
    }
}