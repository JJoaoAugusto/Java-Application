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
import br.com.project.TasksManagement.dto.TaskDto;
import br.com.project.TasksManagement.model.TaskModel;
import br.com.project.TasksManagement.model.UserModel;
import br.com.project.TasksManagement.repository.UserRepository;
import br.com.project.TasksManagement.service.TaskService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    
    @PostMapping("/create")
    public ResponseEntity<TaskModel> createTask(@Valid @RequestBody final TaskDto data, @PathVariable final String userId) {
        final TaskModel createdTask = taskService.createTask(data, Long.parseLong(userId));
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @GetMapping("/read")
    public ResponseEntity<List<TaskModel>> readTasks() {
        final List<TaskModel> allTasks = taskService.readTasks();
        return new ResponseEntity<>(allTasks, HttpStatus.OK);
    }

    @GetMapping("/retrieve/{taskId}")
    public ResponseEntity<TaskModel> retrieveTask(@PathVariable final String taskId) {
        final TaskModel task = taskService.reatrieveTask(Long.parseLong(taskId));
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PutMapping("/update/{taskId}")
    public ResponseEntity<TaskModel> updateTask(@Valid @RequestBody final TaskDto data, @PathVariable final String taskId) {
        final TaskModel task = taskService.updateTask(data, Long.parseLong(taskId));
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable final String taskId) {
        taskService.deleteTask(Long.parseLong(taskId));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

