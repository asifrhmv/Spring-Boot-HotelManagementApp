package com.asif.hotel_reservation.model;

import com.asif.hotel_reservation.enums.RoomCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String roomNumber;

    private double pricePerNight;

    private boolean available;

    @Enumerated(EnumType.STRING)
    private RoomCategory category;

    @ManyToOne
    @JoinColumn(name="hotel_id")
    private Hotel hotel;
}
