package com.example.review.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateEditRestaurantMenu {
    private final String name;
    private final Integer price;
}
