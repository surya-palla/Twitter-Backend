package com.suryapalla.twitter_backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Tweet")
public class Tweet {
    @MongoId
    private String id;
    private Instant createdAt;
    private Instant updatedAt;
    private String content;
    private String image;
    private Number impression = 0;
    private String user_id;
}
