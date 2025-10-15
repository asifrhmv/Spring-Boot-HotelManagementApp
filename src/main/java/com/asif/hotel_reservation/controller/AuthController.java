package com.asif.hotel_reservation.controller;

import com.asif.hotel_reservation.AuthRequest;
import com.asif.hotel_reservation.model.User;
import com.asif.hotel_reservation.repository.UserRepository;
import com.asif.hotel_reservation.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public String register(@RequestBody AuthRequest authRequest){
        if(userRepository.findByUsername(authRequest.getUsername()).isPresent()){
            return "Username artiq movcuddur !";
        }
        User user=User.builder()
                .username(authRequest.getUsername())
                .password(passwordEncoder.encode(authRequest.getPassword()))
                .role(com.asif.hotel_reservation.enums.Role.USER)
                .build();
        userRepository.save(user);
        return "User yaradildi: " + authRequest.getUsername();
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest authRequest){
        User user=userRepository.findByUsername(authRequest.getUsername())
                .orElseThrow(()->new UsernameNotFoundException("Username tapilmadi !"));
        if(!passwordEncoder.matches(authRequest.getPassword(), user.getPassword())){
            throw new RuntimeException("Parol yanlishdir !");
        }
        return jwtUtil.generateToken(user.getUsername());
    }



}
