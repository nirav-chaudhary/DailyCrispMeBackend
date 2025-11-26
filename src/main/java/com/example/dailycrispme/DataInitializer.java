package com.example.dailycrispme;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class DataInitializer {

    private final InMemoryArticleService articleService;

    public DataInitializer(InMemoryArticleService articleService) {
        this.articleService = articleService;
    }

    @PostConstruct
    public void initData() {
        // Mock data
        Author author1 = new Author("Sarah Chen", "/avatars/sarah.jpg");
        Article article1 = new Article("1", "future-of-ai-design", "The Future of AI in Modern Interface Design", "Design", "How artificial intelligence is reshaping...", "<p>Full HTML content...</p>", "2 hours ago", author1);
        articleService.addArticle(article1);

        Author author2 = new Author("John Doe", "/avatars/john.jpg");
        Article article2 = new Article("2", "the-rise-of-serverless", "The Rise of Serverless Architectures", "Technology", "Exploring the benefits and challenges of serverless...", "<p>Full HTML content...</p>", "1 day ago", author2);
        articleService.addArticle(article2);
    }
}
