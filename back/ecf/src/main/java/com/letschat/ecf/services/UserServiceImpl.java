package com.letschat.ecf.services;

import com.letschat.ecf.dtos.UserDto;
import com.letschat.ecf.entities.User;
import com.letschat.ecf.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setId(user.getId());
        return userDto;
    }

    @Override
    public boolean saveUser(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setBirthDate(userDto.getBirthDate());
        userRepository.save(user);
        if(user.getId() != null){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public UserDto findById(Integer id) {
        User user = userRepository.findById(id).get();
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setBirthDate(user.getBirthDate());
        userDto.setLastKnownPresence(user.getLastKnownPresence());
        return userDto;
    }
}
