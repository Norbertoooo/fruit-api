package com.vitu.fruit.api.repository;

import com.vitu.fruit.api.domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Long> {

    Optional<Fruit> findByName(String name);
}
