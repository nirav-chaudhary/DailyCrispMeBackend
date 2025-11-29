package com.example.dailycrispme.repository;

import com.example.dailycrispme.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, String> {
    Optional<ArticleEntity> findBySlug(String slug);
}
