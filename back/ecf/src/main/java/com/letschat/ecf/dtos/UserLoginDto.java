package com.letschat.ecf.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserDto {

    @Size(min = 5, max = 255)
    @NotBlank
    private String email;

    @Size(min = 3, max = 255)
    @NotBlank
    private String password;

    public UserDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserDto() {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
