package com.example.review.service;

import com.example.review.api.request.CreateEditRestaurantRequest;
import com.example.review.api.response.RestaurantDetailView;
import com.example.review.api.response.RestaurantView;
import com.example.review.model.MenuEntity;
import com.example.review.model.RestaurantEntity;
import com.example.review.model.ReviewEntity;
import com.example.review.repository.MenuRepository;
import com.example.review.repository.RestaurantRepository;
import com.example.review.repository.ReviewRepository;
import com.example.review.service.DTO.ReviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.List;


@RequiredArgsConstructor
@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;
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
                    .createAt(ZonedDateTime.now())
                    .updateAt(ZonedDateTime.now())
                    .build();

            menuRepository.save(menuEntity);
        });

        return restaurant;
    }
    @Transactional
    public void editRes(CreateEditRestaurantRequest request, Long restaurantId){
        RestaurantEntity restaurant = restaurantRepository.findById(restaurantId).orElseThrow(() -> new RuntimeException("없는 레스토랑 입니다"));
        restaurant.changenameadress(request.getName(), request.getAdress());
        restaurantRepository.save(restaurant);

        List<MenuEntity> menus = menuRepository.findAllByRestaurantId(restaurantId);
        menuRepository.deleteAll(menus);

        request.getMenus().forEach((menu)-> {
            MenuEntity menuEntity = MenuEntity.builder()
                    .restaurantId(restaurant.getId())
                    .name(menu.getName())
                    .price(menu.getPrice())
                    .createAt(ZonedDateTime.now())
                    .updateAt(ZonedDateTime.now())
                    .build();

            menuRepository.save(menuEntity);
        });

    }
    @Transactional
    public void deleteRes(Long restaurantId){
    RestaurantEntity restaurant = restaurantRepository.findById(restaurantId).orElseThrow(() -> new  RuntimeException("없는 레스토랑 입니다"));
    restaurantRepository.delete(restaurant);
    List<MenuEntity> menus = menuRepository.findAllByRestaurantId(restaurantId);
    menuRepository.deleteAll(menus);
    }

    @Transactional(readOnly = true)
    public List<RestaurantView> getAllRestaurants() {
        List<RestaurantEntity> restaurants = restaurantRepository.findAll();
        return restaurants.stream().map((restaurant)->RestaurantView.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .adress(restaurant.getAdress())
                .createdAt(restaurant.getCreateAt())
                .updatedAt(restaurant.getUpdateAt())
                .build()
        ).toList();
    }

    @Transactional(readOnly = true)
    public RestaurantDetailView getRestaurantDetailView(Long restaurantId) {
        RestaurantEntity restaurant = restaurantRepository.findById(restaurantId).orElseThrow();
        List<MenuEntity> menus = menuRepository.findAllByRestaurantId(restaurantId);
        return RestaurantDetailView.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .adress(restaurant.getAdress())
                .createdAt(restaurant.getCreateAt())
                .updatedAt(restaurant.getUpdateAt())
                .menus(
                        menus.stream().map(menu -> RestaurantDetailView.Menu.builder()
                                        .id(menu.getId())
                                        .name(menu.getName())
                                        .price(menu.getPrice())
                                        .updatedAt(menu.getUpdateAt())
                                        .createdAt(menu.getCreateAt())
                                        .build()
                ).toList()
        )
        .build();
    }
    public ReviewDto getRestaurantReview(Long restaurantId, Pageable page){
        Double avgScore = reviewRepository.getAvgScoreByRestaurantId(restaurantId);
        Slice<ReviewEntity> reviews = reviewRepository.findSliceByRestaurantId(restaurantId,page);

        return ReviewDto.builder()
                .avgScore(avgScore)
                .reviews(reviews.getContent())
                .page(
                        ReviewDto.ReviewDtoPage.builder()
                                .limit(page.getPageSize())
                                .offset(page.getPageNumber() * page.getPageSize())
                                .build()
                )
                .build();
    }

}