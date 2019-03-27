package com.example.demo.Consultant;

import com.example.demo.Consultant.Consultant;
import com.example.demo.Consultant.ConsultantRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

import static org.aspectj.bridge.MessageUtil.info;

@RestController
public class ConsultantController {

    private ConsultantRepository repository;

    public ConsultantController(ConsultantRepository repository){
        this.repository = repository;
    }

    @GetMapping("/consultants")
    @CrossOrigin
    public Collection<Consultant> consultants() {
        return repository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/consultants")
    @CrossOrigin
    public Consultant newConsultant(@RequestBody Consultant newConsultant){
        return repository.save(newConsultant);
    }

    @GetMapping(path = {"/consultants/{id}"})
    @CrossOrigin
    public Consultant findOne(@PathVariable("id") long id){
        return repository.findById(id).get();
    }


    @RequestMapping(value = "/consultants/{id}", method = RequestMethod.PUT)
    @CrossOrigin
    public @ResponseBody
    Consultant updateConsultant(@RequestBody Consultant consultant){
        System.out.println(info(consultant.toString()));
        return repository.save(consultant);
    }

    @RequestMapping(value = "/consultants/{id}", method = RequestMethod.DELETE)
    @CrossOrigin
    public ResponseEntity<Void> deleteConsultantById(@PathVariable("id") long id){
        repository.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    public ConsultantRepository getRepository() {
        return repository;
    }


}
