package com.rubincomputers.vote_lunch.web.restaurant;

import com.rubincomputers.vote_lunch.model.Restaurant;
import com.rubincomputers.vote_lunch.service.RestaurantService;
import com.rubincomputers.vote_lunch.web.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = RestaurantRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantRestController extends AbstractController {

    static final String REST_URL = "/rest/restaurants";

    @Autowired
    protected RestaurantService service;

    @GetMapping("/{id}")
    public Restaurant get(@PathVariable int id) {
        log.info("get {}", id);
        return service.get(id);
    }

    @GetMapping
    public List<Restaurant> getAll() {
        log.info("getAll");
        return service.getAll();
    }

    @GetMapping("/with-dishes")
    public List<Restaurant> getAllByDateWithDishes(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam LocalDate date) {
        log.info("getAllByDateWithDishes, date={}", date);
        return service.getAllByDateWithDishes(date);
    }


}
