package com.therestapi.restapidemo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
class RestApiController {
    private List<Coffee> coffeeList = new ArrayList<>();

    public RestApiController() {
        coffeeList.addAll(List.of(
                new Coffee("Cafee Grajd"),
                new Coffee("Café Ganador"),
                new Coffee("Café Lareño"),
                new Coffee("Café Três Pontas")
        ));
    }

    @GetMapping("/coffee")
    Iterable<Coffee> getCoffee() {
        return coffeeList;
    }

    @GetMapping("/coffee/{id}")
    Optional<Coffee> getCoffeeById(@PathVariable String id) {
        for (Coffee c : coffeeList) {
            if (c.getId().equals(id)) {
                return Optional.of(c);
            }
        }
        return Optional.empty();
    }

    @PostMapping("/coffee")
    @ResponseStatus
    Coffee postCoffee(@RequestBody Coffee coffee) {
        coffeeList.add(coffee);
        return coffee;
    }


    //TODO INDEXOF https://vertex-academy.com/tutorials/ru/indexof-java/
    @PutMapping("/coffee/{id}")
    Coffee putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
        int coffeeIndex = -1;

        for (Coffee c : coffeeList) {
            if (coffee.getId().equals(id)) {
                coffeeIndex = coffeeList.indexOf(c);
                coffeeList.set(coffeeIndex, coffee);

            }
        }
        return (coffeeIndex == -1) ? postCoffee(coffee) : coffee;
    }

    @DeleteMapping("/coffee/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteCoffee(@PathVariable String id){
        coffeeList.removeIf(c->c.getId().equals(id));
    }

}
