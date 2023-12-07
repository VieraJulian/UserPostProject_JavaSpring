package com.UserPostProject.Posts.infrastructure.inputport;

import com.UserPostProject.Posts.infrastructure.dto.PostDTO;

import java.util.List;

public interface IPostInputPort {

    public PostDTO createPost(PostDTO post);

    public PostDTO updatePost(String id, PostDTO post);

    public PostDTO getPost(String id);

    public List<PostDTO> getUserPosts(String userId);

    public List<PostDTO> getAll();

    public void deletePost(String id);
}
