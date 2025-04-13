package com.barber.shop.api.controller;

import com.barber.shop.api.dto.BarberWorkCreationDto;
import com.barber.shop.api.dto.BarberWorkDto;
import com.barber.shop.api.service.BarberWorkService;
import com.barber.shop.api.service.exception.BarberWorkNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/barber-works")
public class BarberWorkController {

  private final BarberWorkService barberWorkService;

  @Autowired
  public BarberWorkController(BarberWorkService barberWorkService) {
    this.barberWorkService = barberWorkService;
  }

  @GetMapping
  public List<BarberWorkDto> getAllWork() {
    return barberWorkService.findAllWork().stream().map(BarberWorkDto::fromEntity).toList();
  }

  @PostMapping
  public BarberWorkDto createWork(@RequestBody BarberWorkCreationDto barberWorkCreationDto) {
    return BarberWorkDto.fromEntity(barberWorkService.create(barberWorkCreationDto.toEntity()));
  }

  @GetMapping("/{id}")
  public BarberWorkDto findWorkById(@PathVariable Long id) throws BarberWorkNotFoundException {
    return BarberWorkDto.fromEntity(barberWorkService.findWorkById(id));
  }

  @PostMapping("/{id}")
  public BarberWorkDto updateWork(
      @PathVariable Long id,
      @RequestBody BarberWorkCreationDto barberWorkCreationDto
  ) throws BarberWorkNotFoundException {
    return BarberWorkDto.fromEntity(barberWorkService.update(id, barberWorkCreationDto.toEntity()));
  }

  @DeleteMapping("/{id}")
  public BarberWorkDto removeWork(@PathVariable Long id) throws BarberWorkNotFoundException {
    return BarberWorkDto.fromEntity(barberWorkService.remove(id));
  }
}
