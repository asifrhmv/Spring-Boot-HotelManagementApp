package com.asif.hotel_reservation.repository;

import com.asif.hotel_reservation.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,Long> {
}
