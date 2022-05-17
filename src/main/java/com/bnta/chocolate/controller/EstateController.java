package com.bnta.chocolate.controller;

import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.service.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EstateController {

    @Autowired
    private EstateService estateService;

    @GetMapping("/estates")
    public List<Estate> getAllEstates() {
        return estateService.getAll();
    }

    @GetMapping("/estates/{id}")
    public Optional<Estate> getEstate(@PathVariable Long id){
        return estateService.get(id);
    }

    @PostMapping("/createNewEstate")
    public void addEstate(@RequestParam(required = true) String name,
                          @RequestParam(required = true) String country) {
        estateService.addEstate(name, country);
    }
}
