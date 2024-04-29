package br.com.project.TasksManagement.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.project.TasksManagement.dto.TaskDto;
import br.com.project.TasksManagement.exception.AppException;
import br.com.project.TasksManagement.model.TaskModel;
import br.com.project.TasksManagement.model.UserModel;
import br.com.project.TasksManagement.repository.TaskRepository;
import br.com.project.TasksManagement.repository.UserRepository;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public TaskModel createTask(final TaskDto data, final Long userId) {
        final UserModel user = userRepository.findById(userId).orElseThrow(() -> new AppException("User not found", HttpStatus.NOT_FOUND));
        final TaskModel task = new TaskModel();
        task.setTitle(data.getTitle());
        task.setStatus(data.getStatus());
        task.setDescription(data.getDescription());
        task.setUser(user);
        return taskRepository.save(task);
    }

    public List<TaskModel> readTasks(){
        return taskRepository.findAll();
    }

    public TaskModel reatrieveTask(final long taskId) {
        return taskRepository.findById(taskId).orElseThrow(() -> new AppException("Task not found", HttpStatus.NOT_FOUND));
    }

    public TaskModel updateTask(final TaskDto data, final long taskId) {
        final TaskModel task = taskRepository.findById(taskId).orElseThrow(() -> new AppException("Task not found", HttpStatus.NOT_FOUND));
        task.setTitle(data.getTitle());
        task.setStatus(data.getStatus());
        task.setDescription(data.getDescription());
        task.setUser(task.getUser());
        return taskRepository.save(task);
    }

    public void deleteTask(final long taskId) {
        final TaskModel task = taskRepository.findById(taskId).orElseThrow(() -> new AppException("Task not found", HttpStatus.NOT_FOUND));
        taskRepository.delete(task);
    }
}