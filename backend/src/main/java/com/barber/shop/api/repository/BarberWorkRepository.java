package com.barber.shop.api.repository;

import com.barber.shop.api.entity.BarberWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarberWorkRepository extends JpaRepository<BarberWork, Long> {

}
