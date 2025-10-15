package com.asif.hotel_reservation;

import com.asif.hotel_reservation.model.Room;
import com.asif.hotel_reservation.repository.RoomRepository;
import com.asif.hotel_reservation.service.RoomService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class RoomServiceTest {
    @Mock
    private RoomRepository roomRepository;

    @InjectMocks
    private RoomService roomService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllRooms(){
        Room room1=new Room();
        room1.setId(1L);
        room1.setRoomNumber("101");

        Room room2=new Room();
        room2.setId(2L);
        room2.setRoomNumber("102");

        when(roomRepository.findAll()).thenReturn(List.of(room1,room2));
        List<Room>rooms=roomService.getAllRooms();

        assertEquals(2,rooms.size());
        verify(roomRepository,times(1)).findAll();
    }
}
