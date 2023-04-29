package com.api.company_manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.company_manager.models.AddressModel;

import jakarta.transaction.Transactional;

@Service
public class AddressService {
    
    @Transactional
    public AddressModel save() {
        return null;
    }

    public List<AddressModel> findAll() {
        return null;
    }

    public Optional<AddressModel> findById() {
        return null;
    }

    @Transactional
    public void delete() {
    }

}
