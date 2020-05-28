package com.letschat.ecf.controllers;

import com.letschat.ecf.dtos.UserDto;
import com.letschat.ecf.dtos.UserLoginDto;
import com.letschat.ecf.entities.User;
import com.letschat.ecf.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @ResponseBody
    public ResponseEntity getUser(@RequestBody @Valid UserLoginDto userLoginDto) {

        UserDto userDto = userService.findUserByEmail(userLoginDto.getEmail());

        if (userDto != null && userDto.getPassword().equals(userLoginDto.getPassword())) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody @Valid UserDto dto) {
        boolean info = userService.saveUser(dto);
        if(info) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
