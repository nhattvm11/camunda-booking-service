package com.demo.booking;


import com.demo.booking.dto.RoomMasterDto;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface RoomMasterRepository extends Neo4jRepository<RoomMasterDto, Long> {

    RoomMasterDto findByName(String name);
}
