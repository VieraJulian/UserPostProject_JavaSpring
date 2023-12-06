package com.UserPostProject.Users.infrastructure.inputport;

import com.UserPostProject.Users.infrastructure.dto.UserDTO;
import com.UserPostProject.Users.infrastructure.dto.UserPostDTO;

import java.util.List;

public interface IUserInputPort {

    public UserDTO createUser(UserDTO user);

    public UserDTO updateUser(String id, UserDTO user);

    public UserPostDTO getUser(String id);

    public List<UserDTO> getAll();

    public void deleteUser(String id);
}
