package com.vitu.fruit.api.service;

import com.vitu.fruit.api.domain.Fruit;
import com.vitu.fruit.api.repository.FruitRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FruitService {

    private final FruitRepository fruitRepository;

    public List<Fruit> getAll() {
        log.info("Getting all fruits");
        return fruitRepository.findAll();
    }

    public Fruit getById(Long id) {
        log.info("Getting fruit by id: {}", id);
        return fruitRepository.findById(id).orElseThrow();
    }

    public Fruit getByName(String name) {
        log.info("Getting fruit by name: {}", name);
        return fruitRepository.findByName(name).orElseThrow();
    }

    public void deleteById(Long id) {
        log.info("Deleting fruit by id: {}", id);
        fruitRepository.deleteById(id);
    }

    public Fruit create(Fruit fruit) {
        log.info("Creating new fruit: {}", fruit);
        return fruitRepository.save(fruit);
    }

    public Fruit update(Fruit fruit) {
        log.info("Updating fruit: {}", fruit);
        return fruitRepository.save(fruit);
    }
}
