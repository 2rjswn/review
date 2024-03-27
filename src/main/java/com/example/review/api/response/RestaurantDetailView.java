package com.example.review.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Builder
public class RestaurantDetailView {
    private final Long id;
    private final String name;
    private final String adress;
    private final ZonedDateTime createdAt;
    private final ZonedDateTime updatedAt;
    private final List<Menu> menus;

    @AllArgsConstructor
    @Getter
    @Builder
    public static class Menu{
        private final Long id;
        private final String name;
        private final Integer price;
        private final ZonedDateTime createdAt;
        private final ZonedDateTime updatedAt;

    }
}
