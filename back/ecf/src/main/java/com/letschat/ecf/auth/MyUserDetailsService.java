//package com.letschat.ecf.auth;
//
//import com.letschat.ecf.entities.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MyUserDetailsService implements UserDetailsService {
//
////    @Autowired
////    private UserRepository userRepository;
//
//    private final MyUserDao myUserDao;
//
//    public MyUserDetailsService(MyUserDao myUserDao) {
//        this.myUserDao = myUserDao;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        return myUserDao
//                .selectUserByUsername(email)
//                .orElseThrow(() -> new UsernameNotFoundException(String.format("Username %s not found", email)));
//    }
//}