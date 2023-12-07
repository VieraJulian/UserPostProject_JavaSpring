package com.UserPostProject.Posts.application;

import com.UserPostProject.Posts.domain.Post;
import com.UserPostProject.Posts.infrastructure.dto.PostDTO;
import com.UserPostProject.Posts.infrastructure.inputport.IPostInputPort;
import com.UserPostProject.Posts.infrastructure.outputport.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostUseCase implements IPostInputPort {

    @Autowired
    private IPostRepository postRepository;

    @Override
    public PostDTO createPost(PostDTO post) {
        Post postInfo = Post.builder()
                .user_id(post.getUser_id())
                .post(post.getPost())
                .build();

        Post postNew = postRepository.createPost(postInfo);

        return PostDTO.builder()
                .id(postNew.getId())
                .user_id(postNew.getUser_id())
                .post(postNew.getPost())
                .build();
    }

    @Override
    public PostDTO updatePost(String id, PostDTO post) {
        Post postFound = postRepository.getById(id);

        postFound.setPost(post.getPost());

        Post postUpdated = postRepository.createPost(postFound);

        return PostDTO.builder()
                .id(postUpdated.getId())
                .user_id(postUpdated.getUser_id())
                .post(postUpdated.getPost())
                .build();
    }

    @Override
    public PostDTO getPost(String id) {
        Post postFound = postRepository.getById(id);

        return PostDTO.builder()
                .id(postFound.getId())
                .user_id(postFound.getUser_id())
                .post(postFound.getPost())
                .build();
    }

    @Override
    public List<PostDTO> getUserPosts(String userId) {
        List<Post> postsDB = postRepository.getByUserId(userId);
        List<PostDTO> postsDTOs = new ArrayList<>();

        for (Post post : postsDB){
            PostDTO postDTO = PostDTO.builder()
                    .id(post.getId())
                    .user_id(post.getUser_id())
                    .post(post.getPost())
                    .build();

            postsDTOs.add(postDTO);
        }

        return postsDTOs;
    }

    @Override
    public List<PostDTO> getAll() {
        List<Post> postsDB = postRepository.getAll();
        List<PostDTO> postsDTOs = new ArrayList<>();

        for (Post post : postsDB) {
            PostDTO postDTO = PostDTO.builder()
                    .id(post.getId())
                    .user_id(post.getUser_id())
                    .post(post.getPost())
                    .build();

            postsDTOs.add(postDTO);
        }

        return postsDTOs;
    }

    @Override
    public void deletePost(String id) {
        postRepository.deletePost(id);
    }
}
