package com.demo.booking.dto;

public class BookingDto {
  private String fullname;
  private String email;
  private String roomType;
  private String date;

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
