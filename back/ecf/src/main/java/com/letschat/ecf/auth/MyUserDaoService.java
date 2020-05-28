//package com.letschat.ecf.auth;
//
//import com.letschat.ecf.entities.User;
//import com.letschat.ecf.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//import static com.letschat.ecf.security.ApplicationUserRole.USER;
//
//
//@Repository("loginData")
//public class MyUserDaoService implements MyUserDao {
//
//    private final PasswordEncoder passwordEncoder;
//
//    private UserRepository userRepository;
//
//    public MyUserDaoService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
//        this.passwordEncoder = passwordEncoder;
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public Optional<MyUserDetails> selectUserByUsername(String email) {
//        User user = userRepository.findByEmail(email);
//        Optional<MyUserDetails> myUserDetails = Optional.of(new MyUserDetails(USER.getGrantedAuthorities(),
//                user.getEmail(),
//                passwordEncoder.encode(user.getPassword()),
//                true,
//                true,
//                true,
//                true));
//
//        return myUserDetails;
//    }
//}
