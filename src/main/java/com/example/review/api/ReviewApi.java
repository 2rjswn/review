package com.example.review.api;

import com.example.review.api.request.CreateReviewRequest;
import com.example.review.service.DTO.ReviewDto;
import com.example.review.service.RestaurantService;
import com.example.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ReviewApi {
    private final ReviewService reviewService;
    private final RestaurantService restaurantService;

    @PostMapping("review")
    public void createReview(@RequestBody CreateReviewRequest request) {
        reviewService.createReview(request.getRestaurantId(), request.getContent(), request.getScore());
    }
    @DeleteMapping("review/{reviewId}")
    public void deleteReview(@PathVariable("reviewId")Long reviewId ) {
        reviewService.deleteReview(reviewId);
    }

    @GetMapping("restaurant/{restaurantId}/review")
    public ReviewDto getRestaurantReviews(@PathVariable("restaurantId")Long restaurantId,
                                          @RequestParam("offset")Integer offset,
                                          @RequestParam("limit")Integer limit) {
        return restaurantService.getRestaurantReview(restaurantId, PageRequest.of(offset/limit, offset));

    }
}
