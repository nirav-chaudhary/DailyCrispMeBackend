package com.example.dailycrispme.service;

import com.example.dailycrispme.model.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleService {
    List<Article> findAll();

    List<Article> findAll(int page, int limit);

    Optional<Article> findBySlug(String slug);
}
