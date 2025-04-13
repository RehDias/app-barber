package com.barber.shop.api.service.exception;

public class AppointmentNotFoundException extends NotFoundException {

  public AppointmentNotFoundException() {
    super("Appointment not found!");
  }
}
