package com.example.demo.mission;

import com.example.demo.Consultant.Consultant;
import com.example.demo.Consultant.ConsultantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class MissionController {
    @Autowired(required = true)
    private MissionRepository repository;
    @Autowired(required = true)
    private ConsultantRepository consultantRepository;

    public MissionController(MissionRepository repository) {this.repository = repository;
    this.consultantRepository = consultantRepository;}


    @GetMapping("/consultants/{id}/missions")
    @CrossOrigin
    public Collection<Mission> getAllMissionsByConsultantId(@PathVariable (value = "id") Long consultantId, Pageable pageable) {
        return repository.findByConsultantId(consultantId, pageable).getContent();
    }

    @PostMapping("/consultants/{consultantId}/missions")
    @CrossOrigin
    public Mission newMission(@RequestBody Mission newMission,
                              @PathVariable (value = "consultantId") Long consultantId
                              ){

        System.out.println("Test" + newMission.getConsultant());
        return consultantRepository.findById(consultantId).map(consultant -> {

            newMission.setConsultant(consultant);

            System.out.println("The new mission : " + newMission.toString());
            return repository.save(newMission);

        }).orElseThrow(() -> new ResourceNotFoundException("Consultant id : " + consultantId + " not found"));
    }

    @GetMapping("/consultants/{consultantId}/missions/{id}") //Find a specific mission of a specific consultant.
    @CrossOrigin
    public Mission getOneMissionByConsultantId(@PathVariable (value = "consultantId") Long consultantId,
                                                           @PathVariable (value = "id") Long id,
                                                           Pageable pageable) {
        return repository.findById(id).get();
    }

    @RequestMapping(value = "/consultants/{consultantId}/missions/{id}", method = RequestMethod.PUT)
    @CrossOrigin
    public Mission updateMission(@RequestBody Mission mission){
        System.out.println(mission.toString());
        return repository.save(mission);
    }

    @RequestMapping(value = "/consultants/{consultantId}/missions/{id}", method= RequestMethod.DELETE)
    @CrossOrigin
    public ResponseEntity<Void> deleteMissionById(@PathVariable("id") long id){
        repository.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
