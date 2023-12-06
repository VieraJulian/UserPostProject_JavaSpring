package com.UserPostProject.Users.infrastructure.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPostDTO {
    private String id;
    private String name;
    private String email;
    List<PostItemDTO> posts;
}
