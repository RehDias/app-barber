package com.barber.shop.api.service;

import com.barber.shop.api.entity.BarberWork;
import com.barber.shop.api.repository.BarberWorkRepository;
import com.barber.shop.api.service.exception.BarberWorkNotFoundException;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class BarberWorkService {

  private final BarberWorkRepository barberWorkRepository;

  @Autowired
  public BarberWorkService(BarberWorkRepository barberWorkRepository) {
    this.barberWorkRepository = barberWorkRepository;
  }

  public List<BarberWork> findAllWork() {
    return barberWorkRepository.findAll();
  }

  public BarberWork findWorkById(Long id) throws BarberWorkNotFoundException {
    return barberWorkRepository.findById(id).orElseThrow(BarberWorkNotFoundException::new);
  }

  public BarberWork create(@Valid BarberWork barberWork) {
    return barberWorkRepository.save(barberWork);
  }

  public BarberWork update(Long id, @Valid BarberWork barberWork) throws BarberWorkNotFoundException {
    BarberWork fromDb = findWorkById(id);

    fromDb.setName(barberWork.getName());
    fromDb.setDuration(barberWork.getDuration());
    fromDb.setPrice(barberWork.getPrice());

    return barberWorkRepository.save(fromDb);
  }

  public BarberWork remove(Long id) throws BarberWorkNotFoundException {
    BarberWork barberWork = findWorkById(id);

    barberWorkRepository.deleteById(id);

    return barberWork;
  }
}
