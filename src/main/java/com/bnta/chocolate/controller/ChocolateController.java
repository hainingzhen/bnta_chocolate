package com.bnta.chocolate.controller;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.service.ChocolateService;
import com.bnta.chocolate.service.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ChocolateController {

    @Autowired
    private ChocolateService chocolateService;
    @Autowired
    private EstateService estateService;


    @GetMapping("/chocolates")
    public List<Chocolate> getAllChocolates(@RequestParam(required = false) Integer percentage) {

        if (percentage == null) {
            return chocolateService.getAll();
        }
        return chocolateService.getByPercentage(percentage);
    }

    @GetMapping("/chocolates/{id}")
    public Optional<Chocolate> getChocolate(@PathVariable Long id) {
        return chocolateService.get(id);
    }

    @PostMapping("/createNewChocolate")
    public void addChocolate(@RequestParam(required = true) String name,
                             @RequestParam(required = true) int percentage,
                             @RequestParam(required = true) Long estateId) {
        Optional<Estate> estateOptional = estateService.get(estateId);
        if (estateOptional.isPresent()) {
            Estate estate = estateOptional.get();
            chocolateService.addChocolate(name, percentage, estate);
        }
    }
}
