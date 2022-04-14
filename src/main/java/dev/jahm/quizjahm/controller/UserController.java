package dev.jahm.quizjahm.controller;

import dev.jahm.quizjahm.model.Friend;
import dev.jahm.quizjahm.model.User;
import dev.jahm.quizjahm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public void createNewUser(@RequestBody User user){
        userService.createNewUser(user);
    }

    /**
     * Returns a User by their username
     * @param username Username to search for
     * @return Matching User
     */
    @GetMapping("/{username}")
    public User getUserById(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @GetMapping
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
