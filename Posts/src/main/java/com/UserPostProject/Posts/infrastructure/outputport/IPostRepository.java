package com.UserPostProject.Posts.infrastructure.outputport;

import com.UserPostProject.Posts.domain.Post;

import java.util.List;

public interface IPostRepository {

    public Post createPost(Post post);

    public Post getById(String id);

    public List<Post> getByUserId(String userId);

    public List<Post> getAll();

    public void deletePost(String id);
}
