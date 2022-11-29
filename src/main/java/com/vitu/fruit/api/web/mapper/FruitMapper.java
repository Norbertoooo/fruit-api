package com.vitu.fruit.api.web.mapper;

import com.vitu.fruit.api.domain.Fruit;
import com.vitu.fruit.api.web.request.FruitRequest;
import com.vitu.fruit.api.web.response.FruitResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FruitMapper {

    private final ModelMapper modelMapper;

    public Fruit toDomain(FruitRequest fruitRequest) {
        return modelMapper.map(fruitRequest, Fruit.class);
    }

    public List<FruitResponse> toResponseList(List<Fruit> fruits) {
        return Arrays.stream(modelMapper.map(fruits, FruitResponse[].class)).collect(Collectors.toList());
    }

    public FruitResponse toResponse(Fruit fruit) {
        return modelMapper.map(fruit, FruitResponse.class);
    }
}
