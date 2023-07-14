package com.demo.booking.dto;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.GeneratedValue;

@Node
public class RoomMasterDto {

    @Id @GeneratedValue private Long id;

    private String roomType;

    private String name;


    @Relationship(type="HAS", direction = Relationship.Direction.INCOMING)
    private List<BookingDto> bookings;

    private RoomMasterDto() {
        // Empty constructor required as of Neo4j API 2.0.5
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoomMasterDto(String roomType, String name) {
        this.roomType = roomType;
        this.name = name;
    }


    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setBookings(List<BookingDto> bookings) {
        this.bookings = bookings;
    }
}