package com.bnta.chocolate.service;

import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstateService {

    @Autowired
    private EstateRepository estateRepository;

    public List<Estate> getAll() {
        return estateRepository.findAll();
    }

    public Optional<Estate> get(Long id) {
        return estateRepository.findById(id);
    }

    public void addEstate(String name, String country) {
        estateRepository.save(new Estate(name, country));
    }
}
