package com.api.company_manager.controllers;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.company_manager.dtos.CompanyDto;
import com.api.company_manager.models.AddressModel;
import com.api.company_manager.models.CompanyModel;
import com.api.company_manager.models.VehicleModel;
import com.api.company_manager.services.AddressService;
import com.api.company_manager.services.CompanyService;
import com.api.company_manager.services.VehicleService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    private CompanyService service;

    @Autowired
    private AddressService addressService;

    @Autowired
    private VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<Object> createCompany(@RequestBody @Valid CompanyDto companyDto) {
        AddressModel address = addressService.findById(companyDto.getId_endereco());
        List<VehicleModel> vehicles = vehicleService.findAllByIds(companyDto.getVehicles_ids());
        var companyModel = new CompanyModel();
        BeanUtils.copyProperties(companyDto, companyModel);
        companyModel.setEndereco(address);
        companyModel.setVeiculos(vehicles);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(companyModel));
    }
}
