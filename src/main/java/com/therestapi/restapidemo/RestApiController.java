package com.therestapi.restapidemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
    Iterable<Coffee>getCoffee(){
        return coffeeList;
    }
}
