package com.example.dailycrispme.dto;

import com.example.dailycrispme.model.Article;
import com.example.dailycrispme.model.NavigationItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record HomeResponse(
        List<NavigationItem> navigation,
        @JsonProperty("hero_article") Article heroArticle,
        @JsonProperty("top_stories") List<TopStoryDto> topStories,
        @JsonProperty("latest_news") List<Article> latestNews) {
}
