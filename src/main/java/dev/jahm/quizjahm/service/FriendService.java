package dev.jahm.quizjahm.service;

import dev.jahm.quizjahm.model.Friend;
import dev.jahm.quizjahm.repository.FriendRepository;
import dev.jahm.quizjahm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendService {

    @Autowired
    FriendRepository friendRepository;

    @Autowired
    UserRepository userRepository;

    public void createNewFriend(Integer friend1, Integer friend2) {
        Friend friendPair = new Friend();
        friendPair.setUser1(userRepository.getById(friend1));
        friendPair.setUser2(userRepository.getById(friend2));
        friendRepository.save(friendPair);
    }

    public List<Friend> getAllFriends() {
        return friendRepository.findAll();
    }
}
