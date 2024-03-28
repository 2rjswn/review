package com.example.review.service.DTO;

import com.example.review.model.ReviewEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

@Builder
@AllArgsConstructor
public class ReviewDto {
    private Double avgScore;
    private List<ReviewEntity> reviews;
    private ReviewDtoPage page;

    public static class ReviewDtoPage{
        private Integer offset;
        private Integer limit;
    }

}
