package br.com.project.TasksManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.project.TasksManagement.model.TaskModel;

public interface TaskRepository extends JpaRepository<TaskModel, Long> {
    
}