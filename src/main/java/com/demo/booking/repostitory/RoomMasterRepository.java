package com.demo.booking.repostitory;


import com.demo.booking.dto.RoomMasterDto;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface RoomMasterRepository extends Neo4jRepository<RoomMasterDto, Long> {

    RoomMasterDto findByRoomType(String roomType);

    RoomMasterDto findByName(String name);

    @Query("MERGE (r:RoomMaster {roomType: $roomType, name: $name})")
    RoomMasterDto createRoomMasterIfNotExists(@Param("roomType") String roomType, @Param("name") String name);

    @Query("MATCH (b:Booking ), (r:RoomMaster {roomType: $roomType }) Where ID(b)=$bookingId CREATE (b)-[:HAS]->(r)")
    RoomMasterDto createConnection(@Param("bookingId") Long bookingId, @Param("roomType") String roomType);
}
