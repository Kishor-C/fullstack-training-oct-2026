package com.servicebooking.controller;

import com.servicebooking.model.ServiceItem;
import com.servicebooking.service.CatalogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    private final CatalogService catalogService;

    public ServiceController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping
    public List<ServiceItem> getAllServices() {
        return catalogService.getAllServices();
    }
}
