package com.rubincomputers.vote_lunch.web.restaurant;

import com.rubincomputers.vote_lunch.model.Restaurant;
import com.rubincomputers.vote_lunch.service.RestaurantService;
import com.rubincomputers.vote_lunch.web.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import static com.rubincomputers.vote_lunch.util.ValidationUtil.assureIdConsistent;

@RestController
@RequestMapping(value = AdminRestaurantRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminRestaurantRestController extends AbstractController {
    static final String REST_URL = "/rest/admin/restaurants";

    @Autowired
    protected RestaurantService service;

    //admin only
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    // admin only
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> createWithLocation(@RequestBody Restaurant restaurant) {
        Restaurant created = service.create(restaurant);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }


    // admin only
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Restaurant restaurant, @PathVariable int id) {
        log.info("update {} with id={}", restaurant, id);
        assureIdConsistent(restaurant, id);
        service.update(restaurant);
    }
}
