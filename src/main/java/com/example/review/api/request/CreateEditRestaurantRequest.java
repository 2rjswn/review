package com.example.review.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CreateEditRestaurantRequest {
    private final String name;
    private final String adress;
    private final List<CreateEditRestaurantMenu> menus;

}
