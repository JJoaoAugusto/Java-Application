package br.com.project.TasksManagement.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserDto {

    @NotEmpty(message = "name can not be empty")
    @Size(max = 92, message = "name must be lower than 32 characters long")
    private String name;

    @NotEmpty(message = "password can not be empty")
    @NotNull(message="password can not be null")
    private String password;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
