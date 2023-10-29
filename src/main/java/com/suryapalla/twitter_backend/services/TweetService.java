package com.suryapalla.twitter_backend.services;

import com.suryapalla.twitter_backend.entity.Tweet;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import com.suryapalla.twitter_backend.pojo.TweetResponse;
import com.suryapalla.twitter_backend.repository.TweetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@Slf4j
public class TweetService {
    @Autowired
    private TweetRepository tweetRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public void creatTweet(Tweet tweet){
        log.info("Creating Tweet by: "+tweet.getUser_id());
        tweet.setCreatedAt(Instant.now());
        tweet.setUpdatedAt(Instant.now());
        tweetRepository.save(tweet);
    }

    public List<TweetResponse> getTweets(){
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.lookup("User", "user_id", "_id", "user")
        );

        AggregationResults<TweetResponse> results = mongoTemplate.aggregate(aggregation, "Tweet", TweetResponse.class);
        return results.getMappedResults();
    }
}
