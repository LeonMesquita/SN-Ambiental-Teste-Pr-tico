package com.api.company_manager.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.company_manager.models.CompanyModel;

public interface CompanyRepository extends JpaRepository<CompanyModel, Integer>{
    
    Optional<CompanyModel> findByCnpj(String cnpj);

    Optional<CompanyModel> findByEmail(String email);
}
