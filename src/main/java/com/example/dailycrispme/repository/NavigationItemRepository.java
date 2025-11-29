package com.example.dailycrispme.repository;

import com.example.dailycrispme.entity.NavigationItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NavigationItemRepository extends JpaRepository<NavigationItemEntity, Long> {
    List<NavigationItemEntity> findAllByOrderByDisplayOrderAsc();
}
