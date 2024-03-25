package com.example.review.service;

import com.example.review.api.request.CreateEditRestaurantRequest;
import com.example.review.model.MenuEntity;
import com.example.review.model.RestaurantEntity;
import com.example.review.repository.MenuRepository;
import com.example.review.repository.RestaurantRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@RequiredArgsConstructor
@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final MenuRepository menuRepository;

    @Transactional
    public RestaurantEntity createRes(CreateEditRestaurantRequest request){
        RestaurantEntity restaurant = RestaurantEntity.builder()
                .name(request.getName())
                .adress(request.getAdress())
                .createAt(ZonedDateTime.now())
                .updateAt(ZonedDateTime.now())
                .build();

        restaurantRepository.save(restaurant);

        request.getMenus().forEach((menu)->{
            MenuEntity menuEntity = MenuEntity.builder()
                    .restaurantId(restaurant.getId())
                    .name(menu.getName())
                    .price(menu.getPrice())
                    .build();

            menuRepository.save(menuEntity);
        });

        return restaurant;
    }
    public void editRes(){

    }
    public void deleteRes(){

    }
}