package dev.jahm.quizjahm.repository;

import dev.jahm.quizjahm.model.Friend;
import dev.jahm.quizjahm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    /**
     * Return a Friend list of Users who are listed as user1 or user2.
     * Both arguments (user1 and user2) are meant to be the same when calling this method.
     * @param username Username to find
     * @return Matching User
     */
    User findByUsername(String username);
}
