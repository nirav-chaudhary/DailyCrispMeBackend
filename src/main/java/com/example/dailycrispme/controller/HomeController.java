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
        private final com.example.dailycrispme.repository.NavigationItemRepository navigationItemRepository;

        public HomeController(ArticleService articleService,
                        com.example.dailycrispme.repository.NavigationItemRepository navigationItemRepository) {
                this.articleService = articleService;
                this.navigationItemRepository = navigationItemRepository;
        }

        @GetMapping("/home")
        public ResponseEntity<HomeResponse> getHomeData() {
                List<Article> allArticles = articleService.findAll();

                // Navigation from DB
                List<NavigationItem> navigation = navigationItemRepository.findAllByOrderByDisplayOrderAsc().stream()
                                .map(item -> new NavigationItem(item.getId(), item.getLabel(), item.getSlug()))
                                .collect(Collectors.toList());

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
