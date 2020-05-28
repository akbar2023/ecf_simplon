package com.letschat.ecf.dtos;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class UserDto {

    @NotEmpty
    @Size(min = 3, max = 255)
    private String firstName;

    @NotEmpty
    @Size(min = 3, max = 255)
    private String lastName;

    @NotEmpty
    @Size(min = 3, max = 255)
    private String password;

    @Email
    private String email;

    @Past
    private LocalDate birthDate;

    private LocalDate lastKnownPresence;


    public UserDto(@NotEmpty @Size(min = 3, max = 255) String firstName,
                   @NotEmpty @Size(min = 3, max = 255) String lastName,
                   @NotEmpty @Size(min = 3, max = 255) String password,
                   @Email String email,
                   @Past LocalDate birthDate,
                   LocalDate lastKnownPresence) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.birthDate = birthDate;
        this.lastKnownPresence = lastKnownPresence;
    }

    public UserDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getLastKnownPresence() {
        return lastKnownPresence;
    }

    public void setLastKnownPresence(LocalDate lastKnownPresence) {
        this.lastKnownPresence = lastKnownPresence;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "UserCreateDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
