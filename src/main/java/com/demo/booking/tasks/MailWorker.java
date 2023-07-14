package com.demo.booking.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.booking.dto.BookingDto;
import com.demo.booking.services.MailService;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.VariablesAsType;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class MailWorker {

  private Logger LOGGER = LoggerFactory.getLogger(MailWorker.class);

  @Autowired
  MailService mailService;

  @JobWorker(type = "send_mail")
  public Map<String, Object> sendMail(final ActivatedJob job, @VariablesAsType BookingDto bookingDto) {
    String message = "Mail has been sent to " + bookingDto.getFullname();
    LOGGER.info(message);
    return Map.of("message", message);
  }
}
