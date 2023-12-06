package com.UserPostProject.Users.infrastructure.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private String id;
    private String name;
    private String email;
}
