package com.demo.booking.services;

import com.demo.booking.dto.RoomMasterDto;
import com.demo.booking.repostitory.RoomMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomMasterService {
    @Autowired
    RoomMasterRepository roomMasterRepository;

    public void createDummyData(){
        RoomMasterDto r1 = new RoomMasterDto("Room 1", "Room Master 1");
        RoomMasterDto r2 = new RoomMasterDto("Room 2", "Room Master 2");
        RoomMasterDto r3 = new RoomMasterDto("Room 3", "Room Master 3");
        RoomMasterDto r4 = new RoomMasterDto("Room 4", "Room Master 4");
        RoomMasterDto r5 = new RoomMasterDto("Room 5", "Room Master 5");
        roomMasterRepository.createRoomMasterIfNotExists(r1.getRoomType(), r1.getName());
        roomMasterRepository.createRoomMasterIfNotExists(r2.getRoomType(), r2.getName());
        roomMasterRepository.createRoomMasterIfNotExists(r3.getRoomType(), r3.getName());
        roomMasterRepository.createRoomMasterIfNotExists(r4.getRoomType(), r4.getName());
        roomMasterRepository.createRoomMasterIfNotExists(r5.getRoomType(), r5.getName());
    }
}
