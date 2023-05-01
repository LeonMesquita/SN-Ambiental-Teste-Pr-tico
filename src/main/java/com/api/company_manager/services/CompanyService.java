package com.api.company_manager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.company_manager.models.CompanyModel;
import com.api.company_manager.repositories.CompanyRepository;

import jakarta.transaction.Transactional;

@Service
public class CompanyService {
    
    @Autowired
    private CompanyRepository repository;

    @Transactional
    public CompanyModel save(CompanyModel companyModel) {
        return repository.save(companyModel);
    }

}
