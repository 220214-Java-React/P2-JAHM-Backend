package dev.jahm.quizjahm.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import dev.jahm.quizjahm.model.Friend;
import dev.jahm.quizjahm.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/friends")
public class FriendController {

    @Autowired
    FriendService friendService;

    @GetMapping
    @CrossOrigin
    public List<Friend> getAllFriends() {
        return friendService.getAllFriends();
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

}
