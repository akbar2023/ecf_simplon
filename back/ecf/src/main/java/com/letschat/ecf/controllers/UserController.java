package com.letschat.ecf.controllers;

import com.letschat.ecf.dtos.UserDto;
import com.letschat.ecf.dtos.UserLoginDto;
import com.letschat.ecf.entities.User;
import com.letschat.ecf.repositories.UserRepository;
import com.letschat.ecf.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    private boolean isAuthenticated(UserLoginDto userLoginDto) {
        UserDto userDto = userService.findByEmail(userLoginDto.getEmail());
        if (userDto != null && userDto.getPassword().equals(userLoginDto.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    @PostMapping("/profile/{id}")
    public ResponseEntity getProfile(@PathVariable("id") Integer id, @RequestBody @Valid UserLoginDto userLoginDto) {
        if(this.isAuthenticated(userLoginDto)) {
            UserDto userDto =  userService.findById(id);
            return new ResponseEntity(userDto, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity logUser(@RequestBody @Valid UserLoginDto userLoginDto) {

        if (this.isAuthenticated(userLoginDto)) {
            UserDto userDto =  userService.findByEmail(userLoginDto.getEmail());
            return new ResponseEntity(userDto,HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/new")
    public ResponseEntity createUser(@RequestBody @Valid UserDto dto) {
        boolean info = userService.saveUser(dto);
        if(info) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
