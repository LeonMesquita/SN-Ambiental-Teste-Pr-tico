package com.api.company_manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public Optional<VehicleModel> findByPlate(String plate) {
        return repository.findByPlaca(plate);
    }

    public List<VehicleModel> findAll() {
        return repository.findAll();
    }

    public List<VehicleModel> findAllByIds(List<Integer> ids) {
        return repository.findByIdIn(ids);
    }

    public VehicleModel findById(Integer id) {
        return repository.findById(id)
        .orElseThrow(() -> 
        new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehicle not found"));
    }
    
    @Transactional
    public void delete(VehicleModel vehicle) {
        repository.delete(vehicle);
    }
}
