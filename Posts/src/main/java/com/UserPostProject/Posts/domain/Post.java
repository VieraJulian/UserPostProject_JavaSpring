package com.UserPostProject.Posts.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "posts")
public class Post {

    @Id
    private String id;
    private String user_id;
    private String post;
}
