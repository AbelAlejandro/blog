package com.abel.blog

import com.abel.blog.entities.Article
import com.abel.blog.entities.User
import com.abel.blog.repositories.ArticleRepository
import com.abel.blog.repositories.UserRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
class RepositoriesTests @Autowired constructor(
        val entityManager: TestEntityManager,
        val userRepository: UserRepository,
        val articleRepository: ArticleRepository
) {
    @Test
    fun `When findByIdOrNull then return Article`() {
        val thoreau = User("henrydavidthoreau", "Henry", "Thoreau")
        entityManager.persist(thoreau)
        val article = Article("Walden; or, Life in the Woods",
                "ON THE DUTY OF CIVIL DISOBEDIENCE",
                "When I wrote the following pages, or rather the bulk of them, I lived alone."
                ,thoreau)
        entityManager.persist(article)
        entityManager.flush()
        val found = articleRepository.findByIdOrNull(article.id!!)
        assertThat(found).isEqualTo(article)
    }

    @Test
    fun `When findByLogin then return User`() {
        val thoreau = User("henrydavidthoreau", "Henry", "Thoreau")
        entityManager.persist(thoreau)
        entityManager.flush()
        val user = userRepository.findByLogin(thoreau.login)
        assertThat(user).isEqualTo(thoreau)
    }
}