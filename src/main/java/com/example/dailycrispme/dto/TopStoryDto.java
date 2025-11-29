package com.example.dailycrispme.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TopStoryDto(
        String id,
        String title,
        String category,
        @JsonProperty("thumbnail_url") String thumbnailUrl) {
}
