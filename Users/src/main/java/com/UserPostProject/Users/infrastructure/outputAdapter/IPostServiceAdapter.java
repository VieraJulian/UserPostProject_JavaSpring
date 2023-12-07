package com.UserPostProject.Users.infrastructure.outputAdapter;

import com.UserPostProject.Users.infrastructure.dto.PostDTO;
import com.UserPostProject.Users.infrastructure.outputport.IPostServicePort;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "posts-service")
public interface IPostServiceAdapter extends IPostServicePort {
    @Override
    @GetMapping("/posts/{userId}")
    List<PostDTO> getUserPosts(@PathVariable String userId);
}
