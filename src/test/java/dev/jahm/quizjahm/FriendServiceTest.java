package dev.jahm.quizjahm;

import dev.jahm.quizjahm.model.Friend;
import dev.jahm.quizjahm.model.User;
import dev.jahm.quizjahm.repository.FriendRepository;
import dev.jahm.quizjahm.service.FriendService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class FriendServiceTest {

    User user1 = new User(1, "test1", "test");
    User user2 = new User(2, "test2", "test");
    Friend friend = new Friend();

    List<Friend> friends = new ArrayList<>();

    @Autowired
    FriendService friendService;

    @MockBean
    FriendRepository friendRepository;

    @Test
    public void givenFriendDataCreateNewFriendDoesNotThrowException(){

        Assertions.assertDoesNotThrow(() -> friendService.createNewFriend(user1.getId(), user2.getId()));
    }
    @Test
    public void givenFriendDataDeleteFriendDoesNotThrowException(){

        Assertions.assertDoesNotThrow(() -> friendService.deleteFriend(user1.getId(), user2.getId()));
    }


    @Test
    public void getAllFriendsReturnsFriends (){
        friend.setUser1(user1);
        friend.setUser2(user2);
        friends.add(friend);

        Mockito.when(friendService.getAllFriends()).thenReturn(friends);

        List<Friend> results = friendService.getAllFriends();

        Assertions.assertEquals(friends.get(0), results.get(0));

    }

    @Test
    public void getFriendsByUserReturnsFriends (){
        friend.setUser1(user1);
        friend.setUser2(user2);
        friends.add(friend);

        Mockito.when(friendService.getAllFriends()).thenReturn(friends);

        List<Friend> results = friendService.getFriendsByUser(user1);

        Assertions.assertEquals(friends.get(0), results.get(0));

    }



}
