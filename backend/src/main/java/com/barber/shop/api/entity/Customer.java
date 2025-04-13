package com.barber.shop.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "customers")
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  @NotBlank(message = "The name is required")
  private String name;

  @Column(nullable = false)
  @NotBlank(message = "The phone is required")
  private String phone;

  @Column(nullable = false)
  @Email(message = "The email must be valid")
  @NotBlank(message = "The email is required")
  private String email;

  @OneToMany(mappedBy = "customer")
  private List<Appointment> appointments;
}
