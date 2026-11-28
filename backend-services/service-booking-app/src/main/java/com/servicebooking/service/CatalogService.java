package com.servicebooking.service;

import com.servicebooking.model.ServiceItem;
import com.servicebooking.repository.ServiceItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService {

    private final ServiceItemRepository repository;

    public CatalogService(ServiceItemRepository repository) {
        this.repository = repository;
    }

    public List<ServiceItem> getAllServices() {
        return repository.findAll();
    }

    public ServiceItem getServiceById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found with id: " + id));
    }
}
