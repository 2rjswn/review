package com.example.review.api;

import com.example.review.api.request.CreateEditRestaurantRequest;
import com.example.review.api.response.RestaurantDetailView;
import com.example.review.api.response.RestaurantView;
import com.example.review.model.RestaurantEntity;
import com.example.review.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RestaurantApi {
    private final RestaurantService restaurantService;
    @GetMapping("/restaurants")
    public List<RestaurantView> getRs() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/restaurant/{restaurantId}")
    public RestaurantDetailView getR(@PathVariable Long restaurantId) {
        return restaurantService.getRestaurantDetailView(restaurantId);

    }

    @PostMapping("/restaurant")
    public void postR(@RequestBody CreateEditRestaurantRequest request) {
        restaurantService.createRes(request);
    }

    @PutMapping("/restaurant/{restaurantId}")
    public void putR(@PathVariable Long restaurantId,@RequestBody CreateEditRestaurantRequest request){
        restaurantService.editRes(request, restaurantId);
    }
    @DeleteMapping("/restaurant/{restaurantId}")
    public void deleteR(@PathVariable Long restaurantId){
        restaurantService.deleteRes(restaurantId);
    }
}
