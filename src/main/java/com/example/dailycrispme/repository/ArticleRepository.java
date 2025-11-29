package com.example.dailycrispme.repository;

import com.example.dailycrispme.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import java.util.UUID;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, UUID> {
    Optional<ArticleEntity> findBySlug(String slug);
}
