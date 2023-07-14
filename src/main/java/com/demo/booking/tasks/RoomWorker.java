package com.demo.booking.tasks;

import java.util.Map;

import com.demo.booking.repostitory.BookingRepository;
import com.demo.booking.repostitory.RoomMasterRepository;
import com.demo.booking.dto.RoomMasterDto;
import com.demo.booking.services.RoomMasterService;
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
  @Autowired
  RoomMasterService roomMasterService;

  public static final Logger LOGGER = LoggerFactory.getLogger(RoomWorker.class);
  
  @JobWorker(type = "check")
  public Map<String, Object> booking(final ActivatedJob job, @VariablesAsType BookingDto bookingDto) {
    LOGGER.warn("Checked room completed");
    //create dummy data
    roomMasterService.createDummyData();

    //save booking data
    bookingRepository.save(bookingDto);

    //create relationship
    roomMasterRepository.createConnection(bookingDto.getId(), bookingDto.getRoomType());

    return Map.of("isRoomAvailable", true);
  }
}
