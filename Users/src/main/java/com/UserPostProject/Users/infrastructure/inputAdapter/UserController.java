package com.UserPostProject.Users.infrastructure.inputAdapter;

import com.UserPostProject.Users.infrastructure.dto.UserDTO;
import com.UserPostProject.Users.infrastructure.dto.UserPostDTO;
import com.UserPostProject.Users.infrastructure.inputport.IUserInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserInputPort userInputPort;

    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user){
        try {
            UserDTO userNew = userInputPort.createUser(user);
            return new ResponseEntity<>(userNew, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable String id, @RequestBody UserDTO user){
        try {
            UserDTO userUpdated = userInputPort.updateUser(id, user);
            return new ResponseEntity<>(userUpdated, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<UserPostDTO> getUser(@PathVariable String id){
        try {
            UserPostDTO user = userInputPort.getUser(id);
            return new ResponseEntity<>(user, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getUser(){
        try {
            List<UserDTO> users = userInputPort.getAll();
            return new ResponseEntity<>(users, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id){
        try {
            userInputPort.deleteUser(id);
            return new ResponseEntity<>("User deleted success!", HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
