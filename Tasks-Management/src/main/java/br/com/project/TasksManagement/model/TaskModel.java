package br.com.project.TasksManagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;

@Table(name = "tasks")
public class TaskModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 150, nullable = false)
    private String title;

    @Column(length = 50, nullable = false)
    private String status;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @ManyToOne()
    @JoinColumn(nullable = false, referencedColumnName = "id")
    private UserModel user;

    public TaskModel() {
    }

    public TaskModel(UserModel user, String title, String status, String description) {
        this.user = user;
        this.title = title;
        this.status = status;
        this.description = description;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
