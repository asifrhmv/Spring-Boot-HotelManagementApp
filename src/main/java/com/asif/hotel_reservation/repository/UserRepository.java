package com.asif.hotel_reservation.repository;

import com.asif.hotel_reservation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    public Optional<User>findByUsername(String username);
}
