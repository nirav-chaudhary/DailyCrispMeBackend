package com.example.dailycrispme.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public record TopStoryDto(
                UUID id,
                String title,
                String category,
                @JsonProperty("thumbnail_url") String thumbnailUrl) {
}
