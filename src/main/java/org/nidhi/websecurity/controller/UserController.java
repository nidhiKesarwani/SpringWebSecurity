package org.nidhi.websecurity.controller;

import org.nidhi.websecurity.model.User;
import org.nidhi.websecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/users")
    public List<User> getUser() {
        return userService.getAllUsers();
    }
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        System.out.println(user);
        return userService.verify(user);
    }

}
