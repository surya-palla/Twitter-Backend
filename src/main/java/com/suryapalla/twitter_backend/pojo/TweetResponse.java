package com.suryapalla.twitter_backend.pojo;


import com.suryapalla.twitter_backend.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TweetResponse {
    private String id;
    private Instant createdAt;
    private Instant updatedAt;
    private String content;
    private String image;
    private Number impression;
    private List<User> user;
}
