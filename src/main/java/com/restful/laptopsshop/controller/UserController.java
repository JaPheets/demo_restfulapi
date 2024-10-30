package com.restful.laptopsshop.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restful.laptopsshop.domain.User;
import com.restful.laptopsshop.service.UserService;
import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getHelloWorld() {
        return "Hello";
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") long id) {

        return this.userService.handleFetchUserById(id);

    }

    @GetMapping("/user")
    public List<User> getAllUser() {
        return this.userService.handleFetchAllUser();
    }

    @PostMapping("/user")
    public User createNewUser(@RequestBody User createUser) {
        // User user = new User();
        // user.setEmail("admin@gmail.com");
        // user.setName("admin");
        // user.setPassword("123456");

        User postUser = this.userService.handleCreateUser(createUser);
        return postUser;
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        this.userService.handleDeleteUser(id);
        return "deleteUser";
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody User user) {
        User putUser = this.userService.handleUpdateUser(user);
        return putUser;
    }
}
