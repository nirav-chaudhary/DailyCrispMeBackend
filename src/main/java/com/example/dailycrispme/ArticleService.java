package com.example.dailycrispme;

import java.util.List;

public interface ArticleService {
    List<Article> getAllArticles();
    Article getArticleBySlug(String slug);
}
