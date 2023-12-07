package com.UserPostProject.Posts.infrastructure.inputAdpater;

import com.UserPostProject.Posts.infrastructure.dto.PostDTO;
import com.UserPostProject.Posts.infrastructure.inputport.IPostInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private IPostInputPort postInputPort;

    @PostMapping("/create")
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO post){
        try {
            PostDTO postNew = postInputPort.createPost(post);
            return new ResponseEntity<>(postNew, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PostDTO> updatePost(@PathVariable String id, @RequestBody PostDTO post){
        try {
            PostDTO postUpdated = postInputPort.updatePost(id, post);
            return new ResponseEntity<>(postUpdated, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<PostDTO> getPost(@PathVariable String id){
        try {
            PostDTO post = postInputPort.getPost(id);
            return new ResponseEntity<>(post, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<PostDTO>> getAll(){
        try {
            List<PostDTO> posts = postInputPort.getAll();
            return new ResponseEntity<>(posts, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePost(@PathVariable String id){
        try {
            postInputPort.deletePost(id);
            return new ResponseEntity<>("Post deleted success!!", HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
