package com.example.demo.businessUnit;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class BusinessUnitController {
    private BusinessUnitRepository repository;

    public BusinessUnitController(BusinessUnitRepository repository){
        this.repository = repository;
    }

    @GetMapping("/businessUnits")
    @CrossOrigin(origins= "http://localhost:4200")
    public Collection<BusinessUnit> businessUnits() {
        return repository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = {"/businessUnits/{id}"})
    @CrossOrigin(origins = "http://localhost:4200")
    public BusinessUnit findOne(@PathVariable("id") long id){
        return repository.findById(id).get();
    }

    @PostMapping("/businessUnits")
    @CrossOrigin(origins = "http://localhost:4200")
    public BusinessUnit newBusinessUnit(@RequestBody BusinessUnit newBusinessUnit){
        return repository.save(newBusinessUnit);
    }

}
