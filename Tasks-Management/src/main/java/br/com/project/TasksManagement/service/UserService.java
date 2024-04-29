package br.com.project.TasksManagement.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.project.TasksManagement.dto.UserDto;
import br.com.project.TasksManagement.exception.AppException;
import br.com.project.TasksManagement.model.UserModel;
import br.com.project.TasksManagement.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel createUser(final UserDto data) {
        final UserModel user = new UserModel();
        user.setName(data.getName());
        user.setPassword(data.getPassword());
        return userRepository.save(user);
    }

    public List<UserModel> readUsers(){
        return userRepository.findAll();
    }

    public UserModel reatrieveUser(final long id) {
        return userRepository.findById(id).orElseThrow(() -> new AppException("User not found", HttpStatus.NOT_FOUND));
    }

    public UserModel updateUser(final UserDto data, final long id) {
        final UserModel user = userRepository.findById(id).orElseThrow(() -> new AppException("User not found", HttpStatus.NOT_FOUND));
        user.setName(data.getName());
        user.setPassword(data.getPassword());
        return userRepository.save(user);
    }

    public void deleteUser(final long id) {
        final UserModel user = userRepository.findById(id).orElseThrow(() -> new AppException("User not found", HttpStatus.NOT_FOUND));
        userRepository.delete(user);
    }
}
