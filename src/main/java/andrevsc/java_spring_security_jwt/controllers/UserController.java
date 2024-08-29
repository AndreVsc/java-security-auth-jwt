package andrevsc.java_spring_security_jwt.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import andrevsc.java_spring_security_jwt.models.User;
import andrevsc.java_spring_security_jwt.services.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.context.annotation.Lazy;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(@Lazy UserService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public String postUser(@RequestBody User user) {
        service.createUser(user);
        return "User created";
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User user) {
        service.updateUser(id, user);
        return "User updated";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return "User deleted";
    }
}