package com.barber.shop.api.controller;

import com.barber.shop.api.dto.CustomerCreationDto;
import com.barber.shop.api.dto.CustomerDto;
import com.barber.shop.api.service.CustomerService;
import com.barber.shop.api.service.exception.CustomerNotFoundException;
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
@RequestMapping("/customers")
public class CustomerController {

  private final CustomerService customerService;

  @Autowired
  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping
  public List<CustomerDto> getAllCustomers() {
    return customerService.findAll().stream().map(CustomerDto::fromEntity).toList();
  }

  @PostMapping
  public CustomerDto createCustomer(@RequestBody CustomerCreationDto customerCreationDto) {
    return CustomerDto.fromEntity(customerService.create(customerCreationDto.toEntity()));
  }

  @GetMapping("/{id}")
  public CustomerDto findCustomerById(@PathVariable Long id) throws CustomerNotFoundException {
    return CustomerDto.fromEntity(customerService.findById(id));
  }

  @PostMapping("/{id}")
  public CustomerDto updateCustomer(
      @PathVariable Long id,
      @RequestBody CustomerCreationDto customerCreationDto
  ) throws CustomerNotFoundException {
    return CustomerDto.fromEntity(customerService.update(id, customerCreationDto.toEntity()));
  }

  @DeleteMapping("/{id}")
  public CustomerDto removeCustomer(@PathVariable Long id) throws CustomerNotFoundException {
    return CustomerDto.fromEntity(customerService.remove(id));
  }
}
