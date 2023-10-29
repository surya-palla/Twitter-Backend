package com.suryapalla.twitter_backend.services;

import com.suryapalla.twitter_backend.entity.User;
import com.suryapalla.twitter_backend.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private Exception NoSuchElementException;

    public User createUser(User user){
    log.info("Creating user with userName: "+user.getUsername());
    user = userRepository.save(user);
    log.info("User with userName: ",user.getUsername()," has been created with userId: ",user.getId() );
    return user;
    }

    public User getUserWithId(String id){
        User user = null;
        user = userRepository.findById(id).get();
        return user;
    }

    public Iterable<User> getUsers(){
        Iterable<User> user = userRepository.findAll();
        return user;
    }

}
