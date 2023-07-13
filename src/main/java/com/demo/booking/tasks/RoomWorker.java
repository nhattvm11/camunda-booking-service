package com.demo.booking.tasks;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.demo.booking.dto.BookingDto;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.VariablesAsType;

@Component
public class RoomWorker {
  public static final Logger LOGGER = LoggerFactory.getLogger(RoomWorker.class);
  
  @JobWorker(type = "check")
  public Map<String, Object> booking(final ActivatedJob job, @VariablesAsType BookingDto bookingDto) {
    LOGGER.warn("Checked room completed");

    // TODO:
    // Save Booking DTO to DB
    

    return Map.of("isRoomAvailable", true);
  }
}
