package com.example.springmvccrud.domain.repository;

import com.example.springmvccrud.domain.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
