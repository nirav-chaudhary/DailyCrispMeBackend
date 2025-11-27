package com.example.dailycrispme.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Article(
                String id,
                String slug,
                String title,
                String excerpt,
                Category category,
                String summary,
                String content,
                @JsonProperty("published_at") String publishedAt,
                @JsonProperty("image_url") String imageUrl,
                @JsonProperty("thumbnail_url") String thumbnailUrl,
                @JsonProperty("author_name") String authorName) {
}
