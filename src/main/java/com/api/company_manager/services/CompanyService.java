package com.api.company_manager.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.company_manager.dtos.CompanyDto;
import com.api.company_manager.models.AddressModel;
import com.api.company_manager.models.CompanyModel;
import com.api.company_manager.models.VehicleModel;
import com.api.company_manager.repositories.CompanyRepository;

import jakarta.transaction.Transactional;

@Service
public class CompanyService {
    
    @Autowired
    private CompanyRepository repository;

    @Autowired
    private AddressService addressService;

    @Autowired
    private VehicleService vehicleService;

    @Transactional
    public CompanyModel save(CompanyDto companyDto) {
        AddressModel address = addressService.findById(companyDto.getId_endereco());
        List<VehicleModel> vehicles = vehicleService.findAllByIds(companyDto.getVehicles_ids());
        var companyModel = new CompanyModel();
        BeanUtils.copyProperties(companyDto, companyModel);
        companyModel.setEndereco(address);
        companyModel.setVeiculos(vehicles);
        return repository.save(companyModel);
    }

}
