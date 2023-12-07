package com.UserPostProject.Users.infrastructure.outputAdapter;

import com.UserPostProject.Users.infrastructure.dto.PostDTO;
import com.UserPostProject.Users.infrastructure.outputport.IPostServicePort;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "postservice", url="http://localhost:8001/posts")
public interface IPostServiceAdapter extends IPostServicePort {
    @Override
    @GetMapping("/{userId}")
    List<PostDTO> getUserPosts(@PathVariable String userId);
}
