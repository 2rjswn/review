package com.example.review.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;

@AllArgsConstructor
@Getter
@Builder
public class RestaurantView {
    private final Long id;
    private final String name;
    private final String adress;
    private final ZonedDateTime createdAt;
    private final ZonedDateTime updatedAt;
}