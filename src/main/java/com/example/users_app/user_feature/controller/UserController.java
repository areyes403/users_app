package com.example.users_app.user_feature.controller;

import com.example.users_app.user_feature.domain.model.User;
import com.example.users_app.user_feature.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;

@CrossOrigin(origins = {
        "http://localhost:4200"
})
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> getUsers(){
        return ResponseEntity.ok(userService.findAll());
    }
    @GetMapping(value = "{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id){

        Optional<User> user = userService.findById(id);
        if (user.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error","Usuario no encontrado"));
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User newUser){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(newUser));
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user){
        Optional<User> foundUser = userService.findById(id);
        if (foundUser.isPresent()){
            User userDb = foundUser.get();
            userDb.setEmail(user.getEmail());
            userDb.setLastName(user.getLastName());
            userDb.setName(user.getName());
            userDb.setPassword(user.getPassword());
            userDb.setUsername(user.getUsername());
            return ResponseEntity.status(HttpStatus.OK).body(userService.create(userDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        Optional<User> user = userService.findById(id);
        if (user.isPresent()){
            userService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
