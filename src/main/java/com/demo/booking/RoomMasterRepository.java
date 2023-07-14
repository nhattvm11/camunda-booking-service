package com.demo.booking;


import com.demo.booking.dto.RoomMasterDto;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface RoomMasterRepository extends Neo4jRepository<RoomMasterDto, Long> {

    RoomMasterDto findByRoomType(String roomType);

    @Query("MERGE (r:RoomMasterDto {roomType: $name})")
    RoomMasterDto createRoomMasterIfNotExists(@Param("name") String roomType);

    @Query("MATCH (b:BookingDto ), (r:RoomMasterDto {roomType: $roomType }) Where ID(b)=$bookingId CREATE (b)-[:BOOKED]->(r)")
    RoomMasterDto createConnection(@Param("bookingId") Long bookingId, @Param("roomType") String roomType);
}
