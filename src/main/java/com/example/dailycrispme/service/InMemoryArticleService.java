package com.example.dailycrispme.service;

import com.example.dailycrispme.model.Article;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class InMemoryArticleService implements ArticleService {

    private static final Logger logger = LoggerFactory.getLogger(InMemoryArticleService.class);
    private final Map<String, Article> articles = new ConcurrentHashMap<>();

    public void addArticle(Article article) {
        articles.put(article.slug(), article);
    }

    @Override
    @Cacheable("articles")
    public List<Article> findAll() {
        logger.info("Fetching all articles from service");
        return new ArrayList<>(articles.values());
    }

    @Override
    @Cacheable(value = "article", key = "#slug")
    public Optional<Article> findBySlug(String slug) {
        logger.info("Fetching article with slug: {} from service", slug);
        return Optional.ofNullable(articles.get(slug));
    }
}