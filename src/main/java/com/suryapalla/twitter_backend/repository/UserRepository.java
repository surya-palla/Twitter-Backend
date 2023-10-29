package com.suryapalla.twitter_backend.repository;

import com.suryapalla.twitter_backend.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
}
