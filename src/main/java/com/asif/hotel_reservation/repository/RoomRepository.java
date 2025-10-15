package com.asif.hotel_reservation.repository;

import com.asif.hotel_reservation.enums.RoomCategory;
import com.asif.hotel_reservation.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Long> {
    List<Room> findByCategory(RoomCategory roomCategory);
}
