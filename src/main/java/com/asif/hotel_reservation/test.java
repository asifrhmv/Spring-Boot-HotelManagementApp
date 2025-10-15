package com.asif.hotel_reservation;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class test {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        String password="$2a$10$DOWSDnHdK12f0b1hFX4EteXHfYvN9HrXx8f8uT8Hdx5K1E1VqTPaW";
       String rawPassword="12345";

      boolean matches= encoder.matches(rawPassword,password);
        System.out.println(matches);

      String newPassword=  encoder.encode("12345");
        System.out.println(newPassword);

    }
}
