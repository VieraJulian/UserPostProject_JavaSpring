package com.UserPostProject.Users.application;

import com.UserPostProject.Users.domain.User;
import com.UserPostProject.Users.infrastructure.dto.UserDTO;
import com.UserPostProject.Users.infrastructure.dto.UserPostDTO;
import com.UserPostProject.Users.infrastructure.inputport.IUserInputPort;
import com.UserPostProject.Users.infrastructure.outputport.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserUseCase implements IUserInputPort {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO user) {
        User userInfo = User.builder().
                name(user.getName()).
                email(user.getEmail()).
                build();

        User userNew = userRepository.save(userInfo);

        return UserDTO.builder().
                id(userNew.getId()).
                name(userNew.getName()).
                email(userNew.getEmail()).
                build();
    }

    @Override
    public UserDTO updateUser(String id, UserDTO user) {
        User userFound = userRepository.getById(id);

        userFound.setName(user.getName());
        userFound.setEmail(user.getEmail());

        User userUpdated = userRepository.save(userFound);

        return UserDTO.builder().
                id(userUpdated.getId()).
                name(userUpdated.getName()).
                email(userUpdated.getEmail()).
                build();
    }

    @Override
    public UserPostDTO getUser(String id) {
        return null;
    }

    @Override
    public List<UserDTO> getAll() {
        List<User> users = userRepository.getAll();

        List<UserDTO> usersDTOs = new ArrayList<>();

        for (User user : users) {
            UserDTO userDTO = UserDTO.builder().
                    id(user.getId()).
                    name(user.getName()).
                    email(user.getEmail()).
                    build();

            usersDTOs.add(userDTO);
        }

        return usersDTOs;
    }

    @Override
    public void deleteUser(String id) {
        userRepository.delete(id);
    }
}
