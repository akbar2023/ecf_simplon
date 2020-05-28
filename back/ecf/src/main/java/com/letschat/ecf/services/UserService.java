package com.letschat.ecf.services;

import com.letschat.ecf.dtos.UserDto;
import com.letschat.ecf.entities.User;

public interface UserService {

    UserDto findUserByEmail(String email);

    boolean saveUser(UserDto user);

}
