package com.api.company_manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.company_manager.models.CompanyModel;

public interface CompanyRepository extends JpaRepository<CompanyModel, Integer>{
    
}
