package com.sistema.cardapio.controller;

import com.sistema.cardapio.food.Food;
import com.sistema.cardapio.food.FoodRepository;
import com.sistema.cardapio.food.FoodRequestDTO;
import com.sistema.cardapio.food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FoodResponseDTO> getAll() {
        List<FoodResponseDTO> foodList = repository.findAll().stream()
                .map(FoodResponseDTO::new)
                .collect(Collectors.toList());
        return foodList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){
        Food fooddata = new Food(data);
        repository.save(fooddata);
        return;
    }
}
