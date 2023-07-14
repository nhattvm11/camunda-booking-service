package com.demo.booking.dto;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Set;

@Node("Booking")
public class BookingDto {
  @Id
  @GeneratedValue
  private Long id;
  private String fullname;
  private String email;
  private String roomType;
  private String date;

  public BookingDto(String fullname, String email, String roomType, String date) {
    this.fullname = fullname;
    this.email = email;
    this.roomType = roomType;
    this.date = date;
  }

  public Long getId() {
    return id;
  }

  @Relationship(type = "HAS")
  public Set<RoomMasterDto> roomMasterDtos;

  public String getFullname() {
    return fullname;
  }
  public void setFullname(String fullname) {
    this.fullname = fullname;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getRoomType() {
    return roomType;
  }
  public void setRoomType(String roomType) {
    this.roomType = roomType;
  }
  public String getDate() {
    return date;
  }
  public void setDate(String date) {
    this.date = date;
  }

}
