package com.rubincomputers.vote_lunch.web.dish;

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
import java.util.List;

import static com.rubincomputers.vote_lunch.util.ValidationUtil.assureIdConsistent;

@RestController
@RequestMapping(value = DishRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class DishRestController extends AbstractController {

    static final String REST_URL = "/rest/dishes";

    @Autowired
    protected DishService service;

    @GetMapping("/{id}")
    public Dish get(@PathVariable int id) {
        log.info("get {}", id);
        return service.get(id);
    }

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



    // admin only
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Dish> createWithLocation(@RequestBody Dish dish) {
        Dish created = service.create(dish);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }


    // admin only
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Dish dish, @PathVariable int id) {
        log.info("update {} with id={}", dish, id);
        assureIdConsistent(dish, id);
        service.update(dish);
    }


}
