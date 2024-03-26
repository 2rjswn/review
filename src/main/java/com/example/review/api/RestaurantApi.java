package com.example.review.api;

import com.example.review.api.request.CreateEditRestaurantRequest;
import com.example.review.model.RestaurantEntity;
import com.example.review.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
@RequiredArgsConstructor
@RestController
public class RestaurantApi {
    private final RestaurantService restaurantService;
    @GetMapping("/restaurants")
    public String getRs() {
        return "Rs";
    }

    @GetMapping("/restaurant/{restaurantId}")
    public String getR(@PathVariable Long restaurantId) {
        return "R" + restaurantId;
    }

    @PostMapping("/restaurant")
    public void postR(@RequestBody CreateEditRestaurantRequest request) {
        restaurantService.createRes(request);
    }

    @PutMapping("/restaurant/{restaurantId}")
    public String putR(@PathVariable Long restaurantId,@RequestBody CreateEditRestaurantRequest request){
        return "put"+restaurantId + request.getName()+request.getAdress();
    }
    @DeleteMapping("/restaurant/{restaurantId}")
    public String deleteR(@PathVariable Long restaurantId){
        return "delete" + restaurantId;
    }
}
