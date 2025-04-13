package com.barber.shop.api.dto;

import com.barber.shop.api.entity.BarberWork;
import java.util.List;

public record BarberWorkDto(
    Long id,
    String name,
    Double price,
    String duration,
    List<AppointmentDto> appointments
    ) {
  public static BarberWorkDto fromEntity(BarberWork barberWork) {
    return new BarberWorkDto(
        barberWork.getId(),
        barberWork.getName(),
        barberWork.getPrice(),
        barberWork.getDuration(),
        barberWork.getAppointments() != null
        ? barberWork.getAppointments() .stream().map(AppointmentDto::fromEntity).toList()
            : List.of()
    );
  }
}
