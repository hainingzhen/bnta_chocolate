package com.bnta.chocolate.service;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ChocolateService {

    @Autowired
    private ChocolateRepository chocolateRepository;

    public List<Chocolate> getAll() {
        return chocolateRepository.findAll();
    }

    public Optional<Chocolate> get(Long id) {
        return chocolateRepository.findById(id);
    }

    public void addChocolate(String name, int percentage, Estate estate) {
        chocolateRepository.save(new Chocolate(name, percentage, estate));
    }

    public List<Chocolate> getByPercentage(int percentage) {
        List<Chocolate> chocolateList = chocolateRepository.findChocolateGreaterThan(percentage);
        return chocolateList;
    }
}
