package dev.jahm.quizjahm.service;

import dev.jahm.quizjahm.model.User;
import dev.jahm.quizjahm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void createNewUser(User user){
        userRepository.save(user);
    }
}
