package com.asif.hotel_reservation.service;

import com.asif.hotel_reservation.model.Hotel;
import com.asif.hotel_reservation.model.Room;
import com.asif.hotel_reservation.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HotelService {
    private final HotelRepository hotelRepository;

    public List<Hotel> getAllHotels(){
        return hotelRepository.findAll();
    }

    public Optional<Hotel>getHotelById(Long id){
       return hotelRepository.findById(id);
    }

    public Hotel createHotel(Hotel hotel){
       return hotelRepository.save(hotel);
    }

    public Hotel updateHotel(Long id,Hotel updatedHotel){
return hotelRepository.findById(id).map(hotel -> {
    hotel.setName(updatedHotel.getName());
    hotel.setAddress(updatedHotel.getAddress());
    hotel.setRating(updatedHotel.getRating());
    return hotelRepository.save(hotel);
}).orElseThrow(()->new RuntimeException("Hotel tapilmadi !"));
    }

    public void deleteHotel(Long id){
        hotelRepository.deleteById(id);
    }


}
