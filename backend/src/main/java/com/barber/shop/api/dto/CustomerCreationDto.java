package com.barber.shop.api.dto;

import com.barber.shop.api.entity.Customer;

public record CustomerCreationDto(String name, String phone, String email) {
  public Customer toEntity() {
    return new Customer(name, phone, email);
  }
}
