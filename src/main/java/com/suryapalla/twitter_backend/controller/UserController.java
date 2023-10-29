package com.suryapalla.twitter_backend.controller;

import com.suryapalla.twitter_backend.entity.User;
import com.suryapalla.twitter_backend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/User")
    public ResponseEntity<?> demo(){
        Iterable<User> iterableUsers = userService.getUsers();
        List<User> users = Streamable.of(iterableUsers).toList();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping(value = "/User/{user_id}")
    public ResponseEntity<?> getUserById(@PathVariable("user_id") String user_id){
        User user = userService.getUserWithId(user_id);
        if(user == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON).body("{\"message\": \"No data found for user with user id: "+user_id+"\"}");
        }
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
    @GetMapping(value = "/User/Name/{user_name}")
    public ResponseEntity<?> getUserByUserName(@PathVariable("user_name") String user_name){
        User user = userService.getUserWithUserName(user_name);
        if(user == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON).body("{\"message\": \"No data found for user with user name: "+user_name+"\"}");
        }
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PostMapping(value = "/User")
    public ResponseEntity<?> createUser(@RequestBody User user){
        user = userService.createUser(user);
        if(user != null) {
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body("{\"message\": \"This is a response from post, user created with id: " + user.getId()+"\"}");
        }
        else{
            return ResponseEntity.status(406).contentType(MediaType.APPLICATION_JSON).body("{\"message\": \"User with email or userName already exists, please try again\"}");
        }
    }
}
