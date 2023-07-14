package com.demo.booking.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.demo.booking.BookingRepository;
import com.demo.booking.RoomMasterRepository;
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

    RoomMasterDto r1 = new RoomMasterDto("type1");
    RoomMasterDto r2 = new RoomMasterDto("type2");
    RoomMasterDto r3 = new RoomMasterDto("type3");
    RoomMasterDto r4 = new RoomMasterDto("type4");
    RoomMasterDto r5 = new RoomMasterDto("type5");
    roomMasterRepository.createRoomMasterIfNotExists(r1.getRoomType());
    roomMasterRepository.createRoomMasterIfNotExists(r2.getRoomType());
    roomMasterRepository.createRoomMasterIfNotExists(r3.getRoomType());
    roomMasterRepository.createRoomMasterIfNotExists(r4.getRoomType());
    roomMasterRepository.createRoomMasterIfNotExists(r5.getRoomType());

    bookingRepository.save(bookingDto);


    roomMasterRepository.createConnection(bookingDto.getId(), bookingDto.getRoomType());


    return Map.of("isRoomAvailable", true);
  }
}
