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
  RoomMasterRepository roomMasterRepository;
  public static final Logger LOGGER = LoggerFactory.getLogger(RoomWorker.class);
  
  @JobWorker(type = "check")
  public Map<String, Object> booking(final ActivatedJob job, @VariablesAsType BookingDto bookingDto) {
    LOGGER.warn("Checked room completed");

    RoomMasterDto r = new RoomMasterDto("RoomMaster of "+bookingDto.getRoomType());
    roomMasterRepository.save(r);

    bookingRepository.save(bookingDto);
    List<BookingDto> b = new ArrayList();
    b.add(bookingDto);

    roomMasterRepository.save(r);


    return Map.of("isRoomAvailable", true);
  }
}
