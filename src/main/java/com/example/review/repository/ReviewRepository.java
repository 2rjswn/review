package com.example.review.repository;

import com.example.review.model.MenuEntity;
import com.example.review.model.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long>, ReviewRepositoryCustom {
    public List<ReviewEntity> findAllByRestaurantId(Long restaurantId);
}
