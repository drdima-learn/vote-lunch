package com.rubincomputers.vote_lunch.web.restaurant.dish;

import com.rubincomputers.vote_lunch.model.Dish;
import com.rubincomputers.vote_lunch.service.DishService;
import com.rubincomputers.vote_lunch.web.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import static com.rubincomputers.vote_lunch.util.ValidationUtil.assureIdConsistent;
import static com.rubincomputers.vote_lunch.util.ValidationUtil.checkNew;

@RestController
@RequestMapping(value = AdminDishRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminDishRestController extends AbstractController {
    static final String REST_URL = "/rest/admin/restaurants/{restaurantId}/dishes";

    @Autowired
    protected DishService service;

    @GetMapping("/{id}")
    public Dish get(@PathVariable int restaurantId, @PathVariable int id) {
        log.info("get {}", id);
        return service.get(id, restaurantId);
    }

    // admin only
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Dish> createWithLocation(@RequestBody Dish dish, @PathVariable int restaurantId) {
        log.info("create {}", dish);
        checkNew(dish);
        Dish created = service.create(dish, restaurantId);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(restaurantId,created.getId())
                .toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    // admin only
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Dish dish, @PathVariable int restaurantId, @PathVariable int id) {
        log.info("update {} with id={}, restaurantId={}", dish, id, restaurantId);
        assureIdConsistent(dish, id);
        service.update(dish, restaurantId);
    }

}
