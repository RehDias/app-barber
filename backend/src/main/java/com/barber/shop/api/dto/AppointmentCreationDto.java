package com.barber.shop.api.dto;

import com.barber.shop.api.entity.Appointment;
import java.time.LocalDateTime;

public record AppointmentCreationDto(LocalDateTime dateTime, String notes) {
 public Appointment toEntity() {
   return new Appointment(dateTime, notes);
 }
}
