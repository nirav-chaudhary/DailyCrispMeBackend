package com.example.dailycrispme.model;

public record Article(
        String id,
        String slug,
        String title,
        String category,
        String summary,
        String content,
        String publishedAt,
        Author author
) {
}
