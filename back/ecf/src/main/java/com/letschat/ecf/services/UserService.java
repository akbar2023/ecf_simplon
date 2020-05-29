package com.letschat.ecf.services;

import com.letschat.ecf.dtos.UserDto;
import com.letschat.ecf.entities.User;

import java.util.Optional;

public interface UserService {

    UserDto findByEmail(String email);

    boolean saveUser(UserDto user);

    UserDto findById(Integer id);

}
