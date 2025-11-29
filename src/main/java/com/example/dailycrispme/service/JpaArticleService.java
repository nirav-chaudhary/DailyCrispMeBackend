package com.example.dailycrispme.service;

import com.example.dailycrispme.entity.ArticleEntity;
import com.example.dailycrispme.model.Article;
import com.example.dailycrispme.model.Author;
import com.example.dailycrispme.model.Category;
import com.example.dailycrispme.repository.ArticleRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Primary
public class JpaArticleService implements ArticleService {

    private final ArticleRepository articleRepository;

    public JpaArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll().stream()
                .map(this::mapToModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<Article> findAll(int page, int limit) {
        PageRequest pageRequest = PageRequest.of(page - 1, limit, Sort.by("publishedAt").descending());
        Page<ArticleEntity> articlePage = articleRepository.findAll(pageRequest);
        return articlePage.stream()
                .map(this::mapToModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Article> findBySlug(String slug) {
        return articleRepository.findBySlug(slug)
                .map(this::mapToModel);
    }

    private Article mapToModel(ArticleEntity entity) {
        Category category = new Category(
                entity.getCategory().getId(),
                entity.getCategory().getName(),
                entity.getCategory().getColor());

        Author author = new Author(
                entity.getAuthor().getId(),
                entity.getAuthor().getName(),
                entity.getAuthor().getAvatarUrl());

        return new Article(
                entity.getId(),
                entity.getSlug(),
                entity.getTitle(),
                entity.getExcerpt(),
                category,
                entity.getSummary(),
                entity.getContent(),
                entity.getPublishedAt(),
                entity.getImageUrl(),
                entity.getThumbnailUrl(),
                author);
    }
}
