package com.therestapi.restapidemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    Iterable<Coffee>getCoffee(){
        return coffeeList;
    }

    @GetMapping("/coffee/{id}")
    Optional<Coffee> getCofeeById(@PathVariable String id){
       for (Coffee c: coffeeList){
           if(c.getId().equals(id)){
               return Optional.of(c);
           }
       }
       return Optional.empty();
    }
}
