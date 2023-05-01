package com.api.company_manager.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.company_manager.models.VehicleModel;

public interface VehicleRepository extends JpaRepository<VehicleModel, Integer>{
    Optional<VehicleModel> findByPlaca(String placa);
}
