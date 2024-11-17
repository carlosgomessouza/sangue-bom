//package com.example.sangue_bom.security;
//
//import com.example.sangue_bom.model.User;
//import com.example.sangue_bom.repository.UserRepository;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    private final UserRepository userRepository;
//
//    public CustomUserDetailsService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userRepository.findByLogin(email);
//
//        return org.springframework.security.core.userdetails.User
//                .withUsername(user.getLogin())
//                .password(user.getPassword())
//                .roles(user.getRole()) // Assign roles
//                .build();
//    }
//}
