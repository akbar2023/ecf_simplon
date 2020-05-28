package com.letschat.ecf.dtos;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class UserCreateDto {

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


    public UserCreateDto(String firstName, String lastName, String password, String email, LocalDate birthDate, LocalDate lastKnownPresence) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.birthDate = birthDate;
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
