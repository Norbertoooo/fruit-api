package com.vitu.fruit.api.web;

import com.vitu.fruit.api.domain.Fruit;
import com.vitu.fruit.api.service.FruitService;
import com.vitu.fruit.api.web.mapper.FruitMapper;
import com.vitu.fruit.api.web.request.FruitRequest;
import com.vitu.fruit.api.web.response.FruitResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/fruit")
public class FruitResource {

    private final FruitService fruitService;
    private final FruitMapper fruitMapper;

    @PostMapping
    public ResponseEntity<FruitResponse> createNewFruit(@RequestBody FruitRequest fruitRequest) {

        log.info("Receiving request to create new fruit: {}", fruitRequest);

        Fruit fruit = fruitMapper.toDomain(fruitRequest);

        Fruit createdFruit = fruitService.create(fruit);

        FruitResponse fruitResponse = fruitMapper.toResponse(createdFruit);

        return ResponseEntity.status(HttpStatus.CREATED).body(fruitResponse);
    }

    @GetMapping
    public ResponseEntity<List<FruitResponse>> getAllFruits() {
        log.info("Receiving request to get all fruits");

        List<Fruit> fruits = fruitService.getAll();

        List<FruitResponse> fruitResponses = fruitMapper.toResponseList(fruits);

        return ResponseEntity.ok(fruitResponses);
    }


    @GetMapping("/id/{id}")
    public ResponseEntity<FruitResponse> getFruitById(@PathVariable Long id) {
        log.info("Receiving request to get fruit by id: {}", id);

        Fruit fruit = fruitService.getById(id);

        FruitResponse fruitResponses = fruitMapper.toResponse(fruit);

        return ResponseEntity.ok(fruitResponses);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<FruitResponse> getFruitByName(@PathVariable String name) {
        log.info("Receiving request to get fruit by name: {}", name);

        Fruit fruit = fruitService.getByName(name);

        FruitResponse fruitResponses = fruitMapper.toResponse(fruit);

        return ResponseEntity.ok(fruitResponses);
    }


    @PutMapping
    public ResponseEntity<FruitResponse> updateFruit() {
        return null;
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteFruitById(@RequestParam(name = "fruit-id") Long id) {
        log.info("Receiving request to delete fruit by id: {}", id);

        fruitService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
