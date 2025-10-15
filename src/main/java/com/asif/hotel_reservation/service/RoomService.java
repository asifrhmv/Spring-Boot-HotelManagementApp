package com.asif.hotel_reservation.service;

import com.asif.hotel_reservation.enums.RoomCategory;
import com.asif.hotel_reservation.model.Room;
import com.asif.hotel_reservation.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    public List<Room>getAllRooms(){
        return roomRepository.findAll();
    }

    public Optional<Room>getRoomById(Long id){
        return roomRepository.findById(id);
    }

    public Room createRoom(Room room){
        return roomRepository.save(room);
    }

    public Room updateRoom(Long id,Room updatedRoom){
        return roomRepository.findById(id).map(
                room->{
                    room.setRoomNumber(updatedRoom.getRoomNumber());
                    room.setPricePerNight(updatedRoom.getPricePerNight());
                    room.setAvailable(updatedRoom.isAvailable());
                    return roomRepository.save(room);
                }
        ).orElseThrow(()->new RuntimeException("Otaq tapilmadi !"));
    }

    public void deleteRoom(Long id){
        Room room=roomRepository.findById(id).orElseThrow(()->new RuntimeException("Otaq tapilmadi !"));

        roomRepository.delete(room);
    }

    public List<Room>getRoomsByPriceRange(int minPrice,int maxPrice){
        return roomRepository.findAll().stream()
                .filter(room->room.getPricePerNight()>=minPrice&&room.getPricePerNight()<=maxPrice)
                .collect(Collectors.toList());
    }

    public List<Room>getAvailableRooms(){
        return roomRepository.findAll()
                .stream().filter(Room::isAvailable)
                .collect(Collectors.toList());
    }

public List<Room>getRomsByCategory(RoomCategory category){
      return roomRepository.findByCategory(category);
}

}
