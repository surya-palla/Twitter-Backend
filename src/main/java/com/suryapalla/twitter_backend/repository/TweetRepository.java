package com.suryapalla.twitter_backend.repository;

import com.suryapalla.twitter_backend.entity.Tweeet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetRepository extends CrudRepository<Tweeet, String> {
}
