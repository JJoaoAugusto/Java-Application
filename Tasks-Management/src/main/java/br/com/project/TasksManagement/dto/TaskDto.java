package br.com.project.TasksManagement.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TaskDto {
    @NotEmpty(message = "O título não pode ser nulo")
    @Size(max = 92, message = "O tamanho não pode passar de 92 caracteres")
    private String title;

    @NotEmpty(message = "O status não pode ser nulo")
    @Size(max = 50, message = "O tamanho não pode passar de 50 caracteres")
    private String status;

    @NotEmpty(message = "A task deve conter descrição")
    private String description;

    @NotNull(message = "user id não pode ser nulo")
    private long user_id;

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

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
}