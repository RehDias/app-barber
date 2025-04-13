package com.barber.shop.api.controller;

import com.barber.shop.api.dto.AppointmentCreationDto;
import com.barber.shop.api.dto.AppointmentDto;
import com.barber.shop.api.service.AppointmentService;
import com.barber.shop.api.service.exception.AppointmentNotFoundException;
import com.barber.shop.api.service.exception.BarberWorkNotFoundException;
import com.barber.shop.api.service.exception.CustomerNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

  private final AppointmentService appointmentService;

  @Autowired
  public AppointmentController(AppointmentService appointmentService) {
    this.appointmentService = appointmentService;
  }

  @GetMapping
  public List<AppointmentDto> getAllAppointments() {
    return appointmentService.findAll().stream().map(AppointmentDto::fromEntity).toList();
  }

  @PostMapping
  public AppointmentDto createAppointment(
      @RequestBody AppointmentCreationDto appointmentCreationDto) {
    return AppointmentDto.fromEntity(appointmentService.create(appointmentCreationDto.toEntity()));
  }

  @GetMapping("/{id}")
  public AppointmentDto findAppointmentById(@PathVariable Long id)
      throws AppointmentNotFoundException {
    return AppointmentDto.fromEntity(appointmentService.findById(id));
  }

  @PostMapping("/{id}")
  public AppointmentDto updateAppointment(
      @PathVariable Long id,
      @RequestBody AppointmentCreationDto appointmentCreationDto
  ) throws AppointmentNotFoundException {
    return AppointmentDto.fromEntity(appointmentService.update(
        id, appointmentCreationDto.toEntity()));
  }

  @DeleteMapping("/{id}")
  public AppointmentDto removeAppointment(@PathVariable Long id)
      throws AppointmentNotFoundException {
    return AppointmentDto.fromEntity(appointmentService.remove(id));
  }

  @PutMapping("/{appointmentId}/customers/{customerId}")
  public AppointmentDto setCustomer(
      @PathVariable Long appointmentId,
      @PathVariable Long customerId
  ) throws CustomerNotFoundException, AppointmentNotFoundException {
    return AppointmentDto.fromEntity(appointmentService.setCustomer(appointmentId, customerId));
  }

  @DeleteMapping("/{appointmentId}/customers")
  public AppointmentDto removeCustomer(@PathVariable Long appointmentId)
      throws AppointmentNotFoundException {
    return AppointmentDto.fromEntity(appointmentService.removeCustomer(appointmentId));
  }

  @PutMapping("/{appointmentId}/barber-works/{barberWorkId}")
  public AppointmentDto setBarberWork(
      @PathVariable Long appointmentId,
      @PathVariable Long barberWorkId
  ) throws BarberWorkNotFoundException, AppointmentNotFoundException {
    return AppointmentDto.fromEntity(appointmentService.setBarberWork(appointmentId, barberWorkId));
  }

  @DeleteMapping("/{appointmentId}/barber-works")
  public AppointmentDto removeBarberWork(@PathVariable Long appointmentId)
      throws AppointmentNotFoundException {
    return AppointmentDto.fromEntity(appointmentService.removeBarberWork(appointmentId));
  }
}
