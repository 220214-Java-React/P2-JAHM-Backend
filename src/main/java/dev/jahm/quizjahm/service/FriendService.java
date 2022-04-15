package dev.jahm.quizjahm.service;

import dev.jahm.quizjahm.model.Friend;
import dev.jahm.quizjahm.model.User;
import dev.jahm.quizjahm.repository.FriendRepository;
import dev.jahm.quizjahm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.tools.jconsole.JConsole;

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

    public void deleteFriend(Integer friend1, Integer friend2) {
        Friend friendPair = new Friend();
        friendPair.setUser1(userRepository.getById(friend1));
        friendPair.setUser2(userRepository.getById(friend2));
        if (friendRepository.findByUser1AndUser2(friendPair.getUser1(), friendPair.getUser2()) != null) {
            friendRepository.delete(friendRepository.findByUser1AndUser2(friendPair.getUser1(), friendPair.getUser2()));
        }
        if (friendRepository.findByUser1AndUser2(friendPair.getUser2(), friendPair.getUser1()) != null) {
            friendRepository.delete(friendRepository.findByUser1AndUser2(friendPair.getUser2(), friendPair.getUser1()));
        } else {
            System.err.println("Could not delete friend entry.");
        }
    }

    public List<Friend> getAllFriends() {
        return friendRepository.findAll();
    }

    /**
     * Returns all Friend entries where the supplied User is either user1 or user2.
     * @param user
     * @return
     */
    public List<Friend> getFriendsByUser(User user) {
        return friendRepository.findByUser1OrUser2(user, user);
    }
}
