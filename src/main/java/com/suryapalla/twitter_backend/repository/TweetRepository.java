package com.suryapalla.twitter_backend.repository;

import com.suryapalla.twitter_backend.entity.Tweet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TweetRepository extends MongoRepository<Tweet, String> {

}
