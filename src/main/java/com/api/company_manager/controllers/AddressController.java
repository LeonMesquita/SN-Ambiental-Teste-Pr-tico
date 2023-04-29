package com.api.company_manager.controllers;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.company_manager.dtos.AddressDto;
import com.api.company_manager.models.AddressModel;
import com.api.company_manager.services.AddressService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService service;
    
    @PostMapping
    public ResponseEntity<Object> createAddress(@RequestBody @Valid AddressDto addressDto) {
        var addressModel = new AddressModel();
        BeanUtils.copyProperties(addressDto, addressModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(addressModel));
    }

    @GetMapping
    public String getAllAddresses() {
        return null;
    }


    @GetMapping("/{id}")
    public String getAddressById() {
        return null;
    }

    @PutMapping("/{id}")
    public String updateAddress() {
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteAddress() {
        return null;
    }
}
