package com.example.dailycrispme;

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
