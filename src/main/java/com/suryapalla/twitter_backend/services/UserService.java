package com.suryapalla.twitter_backend.services;

import com.suryapalla.twitter_backend.entity.User;
import com.suryapalla.twitter_backend.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        log.info("Creating user with userName: "+user.getUsername()+" userEmail: "+user.getEmail());
        User userCheck = userRepository.findFirstByEmailOrUsername(user.getEmail(), user.getUsername());
        if(userCheck == null){
            user = userRepository.save(user);
            log.info("User with userName: "+user.getUsername()+" has been created with userId: "+user.getId() );
            return user;
        }
        else{
            log.info("User with userName: "+user.getUsername()+" or with email: "+user.getEmail()+" already exists in database");
            return null;
        }
    }

    public User getUserWithId(String id){
        Optional<User> userCheck = userRepository.findById(id);
        if(userCheck.isEmpty()){
            return null;
        }
        return userCheck.get();
    }

    public User getUserWithUserName(String id){
        return userRepository.findFirstByUsername(id);
    }

    public Iterable<User> getUsers(){
        return userRepository.findAll();
    }

}
