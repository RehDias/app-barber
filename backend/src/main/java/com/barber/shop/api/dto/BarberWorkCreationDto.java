package com.barber.shop.api.dto;

import com.barber.shop.api.entity.BarberWork;

public record BarberWorkCreationDto(String name, Double price, String duration) {
 public BarberWork toEntity() {
   return new BarberWork(name, price, duration);
 }
}
