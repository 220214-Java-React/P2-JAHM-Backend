package dev.jahm.quizjahm.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import dev.jahm.quizjahm.model.Friend;
import dev.jahm.quizjahm.model.User;
import dev.jahm.quizjahm.service.FriendService;
import dev.jahm.quizjahm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/friends")
public class FriendController {

    @Autowired
    FriendService friendService;

    @Autowired
    UserService userService;

    /**
     * Returns the friends list of the user matching this ID number
     * @param id User ID to search for
     * @return Friend list
     */
    @GetMapping("/{id}")
    @CrossOrigin
    public List<Friend> getFriendsByUser(@PathVariable Integer id) {
        return friendService.getFriendsByUser(userService.getUserById(id));
    }

    /**
     * Takes a JSON object from the front end formatted as {"friend1" : userID, "friend2" : userID}
     * @param objectNode
     */
    @PostMapping("/add")
    @CrossOrigin
    public void createNewFriendPair(@RequestBody ObjectNode objectNode) {
        Integer friend1 = objectNode.get("friend1").asInt();
        Integer friend2 = objectNode.get("friend2").asInt();
        friendService.createNewFriend(friend1, friend2);
    }

    /**
     * Mainly for debug purposes. Returns all Friend objects in the system.
     * @return
     */
    @GetMapping("/all")
    @CrossOrigin
    public List<Friend> getAllFriends() {
        return friendService.getAllFriends();
    }

}
