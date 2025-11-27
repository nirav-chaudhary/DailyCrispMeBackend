package com.example.dailycrispme.controller;

import com.example.dailycrispme.dto.HomeResponse;
import com.example.dailycrispme.dto.TopStoryDto;
import com.example.dailycrispme.model.Article;
import com.example.dailycrispme.model.NavigationItem;
import com.example.dailycrispme.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class HomeController {

    private final ArticleService articleService;

    public HomeController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/home")
    public ResponseEntity<HomeResponse> getHomeData() {
        List<Article> allArticles = articleService.findAll();

        // Dummy Navigation
        List<NavigationItem> navigation = List.of(
                new NavigationItem(1L, "News", "news"),
                new NavigationItem(2L, "Tech", "tech"),
                new NavigationItem(3L, "Finance", "finance"));

        // Hero Article (First one for now)
        Article heroArticle = allArticles.stream()
                .filter(a -> "101".equals(a.id()))
                .findFirst()
                .orElse(allArticles.isEmpty() ? null : allArticles.get(0));

        // Top Stories (Next two)
        List<TopStoryDto> topStories = allArticles.stream()
                .filter(a -> "102".equals(a.id()) || "103".equals(a.id()))
                .map(a -> new TopStoryDto(
                        a.id(),
                        a.title(),
                        a.category().name(), // Mapping Category object to String name
                        a.thumbnailUrl()))
                .collect(Collectors.toList());

        // Latest News (All for now, or exclude hero/top)
        List<Article> latestNews = allArticles;

        HomeResponse response = new HomeResponse(
                navigation,
                heroArticle,
                topStories,
                latestNews);

        return ResponseEntity.ok(response);
    }
}
