package com.suryapalla.twitter_backend.controller;

import com.suryapalla.twitter_backend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/User")
    public ResponseEntity<?> demo(){
        return ResponseEntity.status(HttpStatus.OK).body("This is a response");
    }

    @GetMapping(value = "/User/{user_id}")
    public ResponseEntity<?> getUserById(@PathVariable("user_id") String user_id){

        return ResponseEntity.status(HttpStatus.OK).body("This is a response for requesting user with id: "+user_id);
    }
}
