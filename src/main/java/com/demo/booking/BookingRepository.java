package com.demo.booking;


import com.demo.booking.dto.BookingDto;
import com.demo.booking.dto.RoomMasterDto;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface BookingRepository extends Neo4jRepository<BookingDto, Long> {

    BookingDto findByFullname(String fullName);
}
