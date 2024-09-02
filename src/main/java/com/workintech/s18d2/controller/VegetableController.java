package com.workintech.s18d2.controller;


import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.VegetableService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/vegetable")
public class VegetableController {
    private VegetableService manager;

    @Autowired
    public VegetableController(VegetableService manager) {
        this.manager = manager;
    }

    @GetMapping
    public List<Vegetable> getVegetable() {
        return manager.getByPriceAsc();
    }

    @GetMapping("/{id}")
    public Vegetable getVegetableById(@PathVariable Long id) {
        return manager.getById(id);
    }

    @GetMapping("/desc")
    public List<Vegetable> getVegetableDesc() {
        return manager.getByPriceDesc();
    }

    @PostMapping
    public Vegetable saveVegetable(@RequestBody Vegetable vegetable) {
        return manager.save(vegetable);
    }

    @PostMapping("/{name}")
    public List<Vegetable> getVegetableByName(@PathVariable String name) {
        return manager.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Vegetable deleteVegetable(@PathVariable Long id) {
        return manager.delete(id);
    }
}
