package com.barber.shop.api.service;

import com.barber.shop.api.entity.Appointment;
import com.barber.shop.api.entity.BarberWork;
import com.barber.shop.api.entity.Customer;
import com.barber.shop.api.repository.AppointmentRepository;
import com.barber.shop.api.service.exception.AppointmentNotFoundException;
import com.barber.shop.api.service.exception.BarberWorkNotFoundException;
import com.barber.shop.api.service.exception.CustomerNotFoundException;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class AppointmentService {

  private final AppointmentRepository appointmentRepository;
  private final CustomerService customerService;
  private final BarberWorkService barberWorkService;

  @Autowired
  public AppointmentService(AppointmentRepository appointmentRepository,
      CustomerService customerService, BarberWorkService barberWorkService) {
    this.appointmentRepository = appointmentRepository;
    this.customerService = customerService;
    this.barberWorkService = barberWorkService;
  }

  public List<Appointment> findAll() {
    return appointmentRepository.findAll();
  }

  public Appointment findById(Long id) throws AppointmentNotFoundException {
    return appointmentRepository.findById(id).orElseThrow(AppointmentNotFoundException::new);
  }

  public Appointment create(@Valid Appointment appointment) {
    return appointmentRepository.save(appointment);
  }

  public Appointment update(Long id, @Valid Appointment appointment) throws AppointmentNotFoundException {
    Appointment fromDb = findById(id);

    fromDb.setNotes(appointment.getNotes());
    fromDb.setDateTime(appointment.getDateTime());

    return appointmentRepository.save(fromDb);
  }

  public Appointment remove(Long id) throws AppointmentNotFoundException {
    Appointment appointment = findById(id);

    appointmentRepository.deleteById(id);

    return appointment;
  }

  public Appointment setCustomer(Long appointmentId, Long customerId)
      throws AppointmentNotFoundException, CustomerNotFoundException {
    Appointment appointment = findById(appointmentId);
    Customer customer = customerService.findById(customerId);

    appointment.setCustomer(customer);

    return appointmentRepository.save(appointment);
  }

  public Appointment removeCustomer(Long id) throws AppointmentNotFoundException {
    Appointment appointment = findById(id);

    appointmentRepository.deleteById(id);

    return appointment;
  }

  public Appointment setBarberWork(Long appointmentId, Long barberWorkId)
      throws AppointmentNotFoundException, BarberWorkNotFoundException {
    Appointment appointment = findById(appointmentId);
    BarberWork barberWork = barberWorkService.findWorkById(barberWorkId);

    appointment.setBarberWork(barberWork);

    return appointmentRepository.save(appointment);
  }

  public Appointment removeBarberWork(Long id) throws AppointmentNotFoundException {
    Appointment appointment = findById(id);

    appointment.setBarberWork(null);

    return appointmentRepository.save(appointment);
  }
}
