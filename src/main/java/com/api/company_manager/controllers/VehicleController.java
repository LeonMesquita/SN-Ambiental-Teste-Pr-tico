package com.api.company_manager.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.company_manager.dtos.VehicleDto;
import com.api.company_manager.models.VehicleModel;
import com.api.company_manager.services.VehicleService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/vehicle")
public class VehicleController {
    @Autowired
    private VehicleService service;

    @PostMapping
    public ResponseEntity<Object> createVehicle(@RequestBody @Valid VehicleDto vehicleDto) {
        boolean exists = service.existsByPlate(vehicleDto.getPlaca());
        if (exists) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("There is already a car with this license plate");
        }
        var vehicleModel = new VehicleModel();
        BeanUtils.copyProperties(vehicleDto, vehicleModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(vehicleModel));
    }
}
