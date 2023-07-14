package com.demo.booking.tasks;

import java.util.Map;

import com.demo.booking.repostitory.BookingRepository;
import com.demo.booking.repostitory.RoomMasterRepository;
import com.demo.booking.dto.RoomMasterDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.booking.dto.BookingDto;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.VariablesAsType;

@Component
public class RoomWorker {

  @Autowired
  BookingRepository bookingRepository;
  @Autowired
  RoomMasterRepository roomMasterRepository;
  public static final Logger LOGGER = LoggerFactory.getLogger(RoomWorker.class);
  
  @JobWorker(type = "check")
  public Map<String, Object> booking(final ActivatedJob job, @VariablesAsType BookingDto bookingDto) {
    LOGGER.warn("Checked room completed");

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

    bookingRepository.save(bookingDto);


    roomMasterRepository.createConnection(bookingDto.getId(), bookingDto.getRoomType());


    return Map.of("isRoomAvailable", true);
  }
}
