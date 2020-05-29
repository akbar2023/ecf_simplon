package com.letschat.ecf.dtos;

import javax.validation.constraints.*;

public class UserDto {


    Integer id;

    @NotEmpty
    @Size(min = 3, max = 255)
    private String firstName;

    @NotEmpty
    @Size(min = 3, max = 255)
    private String lastName;

    @NotEmpty
    @Size(min = 3, max = 255)
    private String password;

    @NotEmpty
    @Size(min = 5, max = 255)
    private String email;

    @NotEmpty
    private String birthDate;

    private String lastKnownPresence;


    public UserDto(Integer id,@NotEmpty @Size(min = 3, max = 255) String firstName,
                   @NotEmpty @Size(min = 3, max = 255) String lastName,
                   @NotEmpty @Size(min = 3, max = 255) String password,
                   String email,
                   String birthDate,
                   String lastKnownPresence) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.birthDate = birthDate;
        this.lastKnownPresence = lastKnownPresence;
    }

    public UserDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getBirthDate() {
        return birthDate;
    }

    public String getLastKnownPresence() {
        return lastKnownPresence;
    }

    public void setLastKnownPresence(String lastKnownPresence) {
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

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", lastKnownPresence=" + lastKnownPresence +
                '}';
    }
}
