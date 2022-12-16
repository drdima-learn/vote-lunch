package com.rubincomputers.vote_lunch.web.restaurant.dish;

import com.rubincomputers.vote_lunch.model.Dish;
import com.rubincomputers.vote_lunch.service.DishService;
import com.rubincomputers.vote_lunch.web.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = DishRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class DishRestController extends AbstractController {

    static final String REST_URL = "/rest/restaurants/dishes";

    @Autowired
    protected DishService service;



//    @GetMapping
//    public List<Dish> getAll() {
//        log.info("getAll");
//        return service.getAll();
//    }

//    @GetMapping("/with-dishes")
//    public List<Restaurant> getAllByDateWithDishes(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam LocalDate date) {
//        log.info("getAllByDateWithDishes, date={}", date);
//        return service.getAllByDateWithDishes(date);
//    }








}
