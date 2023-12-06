package com.UserPostProject.Users.infrastructure.outputport;

import com.UserPostProject.Users.domain.User;

import java.util.List;

public interface IUserRepository {

    public User save(User user);

    public User getById(String id);

    public List<User> getAll();

    public void delete(String id);
}
