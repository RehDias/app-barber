package com.barber.shop.api.dto;

import com.barber.shop.api.entity.Appointment;
import java.time.LocalDateTime;

public record AppointmentDto(
    Long id,
    LocalDateTime dateTime,
    String notes,
    BarberWorkDto barberWork,
    CustomerDto customer
    ) {
  public static AppointmentDto fromEntity(Appointment appointment) {
    BarberWorkDto barberWorkDto = appointment.getBarberWork() != null ?
        BarberWorkDto.fromEntity(appointment.getBarberWork()) : null;

    CustomerDto customerDto = appointment.getCustomer() != null ?
        CustomerDto.fromEntity(appointment.getCustomer()) : null;

    return new AppointmentDto(
        appointment.getId(),
        appointment.getDateTime(),
        appointment.getNotes(),
        barberWorkDto,
        customerDto
    );
  }
}
