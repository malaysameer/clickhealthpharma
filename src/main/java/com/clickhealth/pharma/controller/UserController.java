package com.clickhealth.pharma.controller;

import com.clickhealth.pharma.user.api.UsersApi;
import com.clickhealth.pharma.user.model.CreateUserRequest;
import com.clickhealth.pharma.user.model.User;
import com.clickhealth.pharma.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import java.util.List;

@RestController
public class UserController implements UsersApi {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<List<User>> listUsers() {
        return ResponseEntity.ok(userService.getAll());
    }

    @Override
    public ResponseEntity<Void> createUser(@Valid CreateUserRequest user) {
        userService.create(user);
        return ResponseEntity.status(201).build();
    }

    @Override
    public ResponseEntity<User> getUserById(Integer id) {
        User user = userService.getById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<Void> updateUser(Integer id, @Valid CreateUserRequest user) {
        userService.update(id, user);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteUser(Integer id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
