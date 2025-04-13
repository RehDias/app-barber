package com.barber.shop.api.dto;

import com.barber.shop.api.entity.Customer;
import java.util.List;

public record CustomerDto(
    Long id,
    String name,
    String phone,
    String email
    ) {
  public static CustomerDto fromEntity(Customer customer) {
    return new CustomerDto(
        customer.getId(),
        customer.getName(),
        customer.getPhone(),
        customer.getEmail()
    );
  }
}
