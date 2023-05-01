package com.api.company_manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.company_manager.models.VehicleModel;

public interface VehicleRepository extends JpaRepository<VehicleModel, Integer>{
    
}
