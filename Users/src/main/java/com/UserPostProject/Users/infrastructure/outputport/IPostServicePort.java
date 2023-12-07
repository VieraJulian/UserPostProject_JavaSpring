package com.UserPostProject.Users.infrastructure.outputport;

import com.UserPostProject.Users.infrastructure.dto.PostDTO;

import java.util.List;

public interface IPostServicePort {
    List<PostDTO> getUserPosts(String userId);

}
