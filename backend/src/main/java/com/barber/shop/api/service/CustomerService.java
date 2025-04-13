package com.barber.shop.api.service;

import com.barber.shop.api.entity.Customer;
import com.barber.shop.api.repository.CustomerRepository;
import com.barber.shop.api.service.exception.CustomerNotFoundException;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class CustomerService {

  private final CustomerRepository customerRepository;

  @Autowired
  public CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public List<Customer> findAll() {
    return customerRepository.findAll();
  }

  public Customer findById(Long id) throws CustomerNotFoundException {
    return customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
  }

  public Customer create(@Valid Customer customer) {
    return customerRepository.save(customer);
  }

  public Customer update(Long id, @Valid Customer customer) throws CustomerNotFoundException {
    Customer fromDb = findById(id);

    fromDb.setName(customer.getName());
    fromDb.setEmail(customer.getEmail());
    fromDb.setPhone(customer.getPhone());

    return customerRepository.save(fromDb);
  }

  public Customer remove(Long id) throws CustomerNotFoundException {
    Customer customer = findById(id);

    customerRepository.deleteById(id);

    return customer;
  }
}
