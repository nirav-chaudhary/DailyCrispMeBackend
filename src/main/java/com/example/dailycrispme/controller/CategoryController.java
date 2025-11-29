package com.example.dailycrispme.controller;

import com.example.dailycrispme.model.NavigationItem;
import com.example.dailycrispme.repository.NavigationItemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {

    private final NavigationItemRepository navigationItemRepository;

    public CategoryController(NavigationItemRepository navigationItemRepository) {
        this.navigationItemRepository = navigationItemRepository;
    }

    @GetMapping("/categories")
    public ResponseEntity<List<NavigationItem>> getCategories() {
        List<NavigationItem> navigation = navigationItemRepository.findAllByOrderByDisplayOrderAsc().stream()
                .map(item -> new NavigationItem(item.getId(), item.getLabel(), item.getSlug()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(navigation);
    }
}
