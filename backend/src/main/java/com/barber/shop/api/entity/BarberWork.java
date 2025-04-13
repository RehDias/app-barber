package com.barber.shop.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "barber_work")
public class BarberWork {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  @NotBlank(message = "The name is required")
  private String name;

  private Double price;
  private String duration;

  @OneToMany(mappedBy = "barberWork")
  private List<Appointment> appointments;

  public BarberWork(String name, Double price, String duration) {
    this.name = name;
    this.price = price;
    this.duration = duration;
  }
}
