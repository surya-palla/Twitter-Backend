package com.suryapalla.twitter_backend.controller;

import com.suryapalla.twitter_backend.entity.Tweet;
import com.suryapalla.twitter_backend.pojo.TweetResponse;
import com.suryapalla.twitter_backend.services.TweetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TweetController {
    @Autowired
    private TweetService tweetService;
    @PostMapping(value = "/Tweet")
    public ResponseEntity<?> createTweet(){
        Tweet tweet = new Tweet();
        tweet.setContent("This is a Third dummy post data content.");
        tweet.setImage("https://hwnews.in/wp-content/uploads/2022/06/NASA-tweet.jpg");
        tweet.setUser_id("653e636a907bdc6f301630f4");
        tweetService.creatTweet(tweet);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body("{\"message\": \"Tweet poseted successfully\"}");
    }

    @GetMapping(value = "/Tweet")
    public  ResponseEntity<?> getTweets(){
        List<TweetResponse> tweetResponse = tweetService.getTweets();


        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(tweetResponse);
    }
}
