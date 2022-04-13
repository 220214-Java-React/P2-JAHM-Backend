package dev.jahm.quizjahm.controller;

import dev.jahm.quizjahm.model.User;
import dev.jahm.quizjahm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    @CrossOrigin
    public void createNewUser(@RequestBody User user){
        userService.createNewUser(user);
    }

    @GetMapping
    @CrossOrigin
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    /**
     * A test endpoint.
     * @return
     */
    @RequestMapping("/hello")
    public @ResponseBody String greeting() {
        return "Hello, World";
    }
}
