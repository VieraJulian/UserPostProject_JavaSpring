package com.UserPostProject.Users.infrastructure.outputAdapter;

import com.UserPostProject.Users.domain.User;
import com.UserPostProject.Users.infrastructure.outputport.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MongoDBRepository implements IUserRepository {

    @Autowired
    private MongoTemplate mt;

    @Override
    public User save(User user) {
        return mt.save(user);
    }

    @Override
    public User getById(String id) {
        return mt.findById(id, User.class);
    }

    @Override
    public List<User> getAll() {
        return mt.findAll(User.class);
    }

    @Override
    public void delete(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        mt.findAndRemove(query, User.class);
    }
}
