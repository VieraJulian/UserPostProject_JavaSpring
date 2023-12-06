package com.UserPostProject.Users.infrastructure.dto;

import lombok.*;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDTO {

    private String id;
    private String user_id;
    private String post;
}
