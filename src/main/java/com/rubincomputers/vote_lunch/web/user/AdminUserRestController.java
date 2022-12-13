package com.rubincomputers.vote_lunch.web.user;

import com.rubincomputers.vote_lunch.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = AdminUserRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminUserRestController extends AbstractUserController {

    static final String REST_URL = "/rest/admin/users";



    @Override
    @GetMapping("/{id}")
    public User get(@PathVariable int id) {
        return super.get(id);
    }

    @GetMapping("/by-email")
    public User getByMail(@RequestParam String email) {
        return service.getByEmail(email);
    }

    @GetMapping
    public List<User> getAll() {
        return service.getAll();
    }





    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createWithLocation(@RequestBody User user) {
        User created = service.create(user);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @Override
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody User user, @PathVariable int id) {
        super.update(user, id);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

}
