package com.api.company_manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.company_manager.dtos.AddressDto;
import com.api.company_manager.models.AddressModel;
import com.api.company_manager.repositories.AddressRepository;

import jakarta.transaction.Transactional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;
    
    @Transactional
    public AddressModel save(AddressModel addressModel) {
        return repository.save(addressModel);
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
