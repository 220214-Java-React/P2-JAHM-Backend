package dev.jahm.quizjahm.repository;

import dev.jahm.quizjahm.model.Friend;
import dev.jahm.quizjahm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Integer> {

    /**
     * Return a Friend list of Users who are listed as user1 or user2.
     * Both arguments (user1 and user2) are meant to be the same when calling this method.
     * @param user1 User to find
     * @param user2 User to find
     * @return Friend list
     */
    List<Friend> findByUser1OrUser2(User user1, User user2);

    Friend findByUser1AndUser2(User user1, User user2);

}
