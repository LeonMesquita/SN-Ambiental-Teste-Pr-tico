package com.api.company_manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.company_manager.models.AddressModel;

public interface AddressRepository extends JpaRepository<AddressModel, Long>{
    
}
