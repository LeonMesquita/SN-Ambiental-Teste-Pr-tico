package com.api.company_manager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.company_manager.models.VehicleModel;
import com.api.company_manager.repositories.VehicleRepository;

import jakarta.transaction.Transactional;

@Service
public class VehicleService {
    
    @Autowired
    private VehicleRepository repository;

    @Transactional
    public VehicleModel save(VehicleModel vehicleModel) {
        return repository.save(vehicleModel);
    }
}
