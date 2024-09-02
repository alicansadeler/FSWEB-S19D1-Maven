package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import com.workintech.s18d2.services.FruitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruit")
public class FruitController {

    private FruitService manager;

    @Autowired
    public FruitController(FruitService fruitService) {
        this.manager = fruitService;
    }

    @GetMapping
    public List<Fruit> getFruit() {
        return manager.getByPriceAsc();
    }

    @GetMapping("/{id}")
    public Fruit getFruitById(@PathVariable Long id) {
        return manager.getById(id);
    }

    @GetMapping("/desc")
    public List<Fruit> getFruitDesc() {
        return manager.getByPriceDesc();
    }

    @PostMapping
    public Fruit saveFruit(@RequestBody Fruit fruit) {
        return manager.save(fruit);
    }

    @GetMapping("/name/{name}")
    public List<Fruit> getFruitByName(@PathVariable String name) {
        return manager.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Fruit deleteFruit(@PathVariable Long id) {
        return manager.delete(id);
    }
}
