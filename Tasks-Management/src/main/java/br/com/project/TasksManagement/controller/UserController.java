package br.com.project.TasksManagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.TasksManagement.dto.UserDto;
import br.com.project.TasksManagement.model.UserModel;
import br.com.project.TasksManagement.service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserModel> createUser(@Valid @RequestBody final UserDto data) {
        final UserModel createdUser = userService.createUser(data);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/read")
    public ResponseEntity<List<UserModel>> readUsers() {
        final List<UserModel> allUsers = userService.readUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/retrieve/{userId}")
    public ResponseEntity<UserModel> retrieveUser(@PathVariable final String userId) {
        final UserModel user = userService.reatrieveUser(Long.parseLong(userId));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<UserModel> updateUser(@Valid @RequestBody final UserDto data, @PathVariable final String userId) {
        final UserModel user = userService.updateUser(data, Long.parseLong(userId));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable final String userId) {
        userService.deleteUser(Long.parseLong(userId));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

