package com.barber.shop.api.service.exception;

public class BarberWorkNotFoundException extends NotFoundException {

  public BarberWorkNotFoundException() {
    super("Service not found!");
  }
}
