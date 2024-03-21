package com.example.review.api;

import com.example.review.api.request.CreateEditRestaurantRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestaurantApi {
    @GetMapping("/restaurants")
    public String getRs() {
        return "Rs";
    }

    @GetMapping("/restaurant/{restaurantId}")
    public String getR(@PathVariable Long restaurantId) {
        return "R" + restaurantId;
    }

    @PostMapping("/restaurant")
    public String postR(@RequestBody CreateEditRestaurantRequest request) {
        return "create"+request.getName()+request.getAdress()+request.getMenus().get(0).getName()+request.getMenus().get(0).getPrice();
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
