package dev.jahm.quizjahm.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import dev.jahm.quizjahm.model.User;
import dev.jahm.quizjahm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    private final BCrypt.Hasher hasher = BCrypt.withDefaults();
    private final String SALT = "sRXwq6fTMJ?gupD.";

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void createNewUser(User user){
        user.setPassword(PasswordEncrypt(user.getPassword()));

        userRepository.save(user);
    }

    /**
     * Get a User by their user ID number
     * @param id The provided user ID
     * @return A User object
     */
    public User getUserById(Integer id) {
        return userRepository.findById(id).get();
    }

    /**
     * Get a User by their username
     * @param username The provided username
     * @return A User object
     */
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public String PasswordEncrypt (String password){ //encrypt the password


        return new String(
                hasher.hash(4, SALT.getBytes(StandardCharsets.UTF_8),
                        password.getBytes(StandardCharsets.UTF_8)),
                StandardCharsets.UTF_8);

    }

}

