package com.api.company_manager.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
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
        return repository.findAll();
    }

    public AddressModel findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> 
        new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found"));
    }

    @Transactional
    public void delete(AddressModel addressModel) {
        repository.delete(addressModel);
    }

}