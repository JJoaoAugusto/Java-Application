package br.com.project.TasksManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.project.TasksManagement.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {

}