package com.api.company_manager.controllers;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.company_manager.dtos.CompanyDto;
import com.api.company_manager.models.CompanyModel;
import com.api.company_manager.services.CompanyService; 
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    private CompanyService service;

    @PostMapping
    public ResponseEntity<Object> createCompany(@RequestBody @Valid CompanyDto companyDto) {
        String conflictError = service.checkCompanyByUniqueFields(companyDto);
        if (conflictError != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(conflictError);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(companyDto));
    }

    @GetMapping
    public ResponseEntity<List<CompanyModel>> getAllCompanies() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Object> getCompanyById(@PathVariable(value = "id") Integer id) {
        CompanyModel company = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(company);
    }

    @GetMapping("/cnpj/{cnpj}")
    public ResponseEntity<Object> getCompanyByCnpj(@PathVariable(value = "cnpj") String cnpj) {
        Optional<CompanyModel> company = service.findByCnpj(cnpj);
        if (!company.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Company not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(company);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCompany(
        @PathVariable(value = "id") Integer id,
        @RequestBody @Valid CompanyDto companyDto
    ) {
        CompanyModel company = service.findById(id);
        Optional<CompanyModel> existsCompany;
        existsCompany = service.findByCnpj(companyDto.getCnpj());
        if (existsCompany.isPresent() && !existsCompany.get().getCnpj().equals(company.getCnpj())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Conflict: There is already a company with this CNPJ");
        }

        existsCompany = service.findByEmail(companyDto.getEmail());
        if (existsCompany.isPresent() && !existsCompany.get().getEmail().equals(company.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Conflict: There is already a company with this Email");
        }

        return ResponseEntity.status(HttpStatus.OK).body(service.update(companyDto, company));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCompany(@PathVariable(value = "id") Integer id) {
        CompanyModel company = service.findById(id);
        service.delete(company);
        return ResponseEntity.status(HttpStatus.OK).body("Company deleted successfully");
    }
}
