package com.api.company_manager.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public String checkCompanyByUniqueFields(CompanyDto companyDto) {
        Optional<CompanyModel> company;
        company = repository.findByCnpj(companyDto.getCnpj());
        if (company.isPresent()) {
            return "Conflict: There is already a company with this CNPJ";
        }
        company = repository.findByEmail(companyDto.getEmail());
        if (company.isPresent()) {
            return "Conflict: There is already a company with this E-mail";
        }
        return null;
    }

    public List<CompanyModel> findAll() {
        return repository.findAll();
    }

    public CompanyModel findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Company not found"));
    }

    public Optional<CompanyModel> findByCnpj(String cnpj) {
        return repository.findByCnpj(cnpj);
    }

    public Optional<CompanyModel> findByEmail(String email) {
        return repository.findByEmail(email);
    }
    
    public CompanyModel update(CompanyDto companyDto, CompanyModel company) {
        List<VehicleModel> vehicles = vehicleService.findAllByIds(companyDto.getVehicles_ids());
        var companyModel = new CompanyModel();
        BeanUtils.copyProperties(companyDto, companyModel);
        companyModel.setId(company.getId());
        companyModel.setVeiculos(vehicles);

        return repository.save(companyModel);
    }

}