package com.api.company_manager.controllers;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/api/address")
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
    public ResponseEntity<List<AddressModel>> getAllAddresses() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> getAddressById(@PathVariable(value = "id") Long id) {
        AddressModel address = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(address);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAddress(
        @PathVariable(value = "id") Long id,
        @RequestBody @Valid AddressDto addressDto
    ) {
        AddressModel address = service.findById(id);
        
        var addressModel = new AddressModel();
        BeanUtils.copyProperties(addressDto, addressModel);
        addressModel.setId(address.id);
        return ResponseEntity.status(HttpStatus.OK).body(service.save(addressModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAddress(@PathVariable(value = "id") Long id) {
        AddressModel address = service.findById(id);

        service.delete(address);
        return ResponseEntity.status(HttpStatus.OK).body("Address deleted successfully");
    }

}
