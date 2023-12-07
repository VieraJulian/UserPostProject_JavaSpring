package com.UserPostProject.Posts.infrastructure.outputAdapter;

import com.UserPostProject.Posts.domain.Post;
import com.UserPostProject.Posts.infrastructure.outputport.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MongoDBRepository implements IPostRepository {

    @Autowired
    private MongoTemplate mt;

    @Override
    public Post createPost(Post post) {
        return mt.save(post);
    }

    @Override
    public Post getById(String id) {
        return mt.findById(id, Post.class);
    }

    @Override
    public List<Post> getByUserId(String userId) {
        Query query = new Query(Criteria.where("user_id").is(userId));
        return mt.find(query, Post.class);
    }

    @Override
    public List<Post> getAll() {
        return mt.findAll(Post.class);
    }

    @Override
    public void deletePost(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        mt.findAndRemove(query, Post.class);
    }
}
