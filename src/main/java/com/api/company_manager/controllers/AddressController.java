package com.api.company_manager.controllers;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/address")
public class AddressController {
    
    @PostMapping
    public String createAddress() {
        return null;
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
