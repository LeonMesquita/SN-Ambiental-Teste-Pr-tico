package com.api.company_manager.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.company_manager.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long>{
    
    Optional<UserModel> findByUsername(String username);
}
