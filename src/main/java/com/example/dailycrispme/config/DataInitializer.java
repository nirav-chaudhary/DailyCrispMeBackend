package com.example.dailycrispme.config;

import com.example.dailycrispme.model.Article;
import com.example.dailycrispme.model.Author;
import com.example.dailycrispme.service.InMemoryArticleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final InMemoryArticleService articleService;

    public DataInitializer(InMemoryArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author1 = new Author("Sarah Chen", "/avatars/sarah.jpg");
        Article article1 = new Article("1", "future-of-ai-design", "The Future of AI in Modern Interface Design", "Design", "How artificial intelligence is reshaping...", "<p>Full HTML content...</p>", "2 hours ago", author1);
        articleService.addArticle(article1);

        Author author2 = new Author("John Doe", "/avatars/john.jpg");
        Article article2 = new Article("2", "the-rise-of-serverless", "The Rise of Serverless Architectures", "Technology", "Exploring the benefits and challenges of serverless...", "<p>Full HTML content...</p>", "1 day ago", author2);
        articleService.addArticle(article2);

        Author author3 = new Author("Jane Smith", "/avatars/jane.jpg");
        Article article3 = new Article("3", "blockchain-beyond-cryptocurrency", "Blockchain: Beyond Cryptocurrency", "Finance", "Understanding the potential of blockchain technology...", "<p>Full HTML content...</p>", "3 days ago", author3);
        articleService.addArticle(article3);

        Author author4 = new Author("Peter Jones", "/avatars/peter.jpg");
        Article article4 = new Article("4", "sustainable-urban-planning", "Sustainable Urban Planning for Future Cities", "Environment", "Innovations in creating eco-friendly urban spaces...", "<p>Full HTML content...</p>", "4 days ago", author4);
        articleService.addArticle(article4);
    }
}