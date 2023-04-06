package ru.ponomarev.springweather.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ponomarev.springweather.model.User;
import ru.ponomarev.springweather.service.UserService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/v1/")
public class UserController {

    private final UserService userService;

    @GetMapping(path = "users")
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    @GetMapping(path = "user")
    public User getUserById(@RequestParam final long id) {
        return userService.getUserById(id);
    }

    @PostMapping(path = "user")
    public List<User> addUser(@RequestBody final User user) {
        return userService.addUser(user);
    }

    @DeleteMapping(path = "user")
    public List<User> deleteUser(@RequestParam final long id) {
        return userService.deleteUser(id);
    }

    @PutMapping (path = "user")
    public List<User> updateUser(@RequestBody final User user) {
        return userService.updateUser(user);
    }
}
