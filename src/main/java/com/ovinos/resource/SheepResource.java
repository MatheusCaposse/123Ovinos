package com.ovinos.resource;

import com.ovinos.DTO.*;
import com.ovinos.entity.Enum.*;
import com.ovinos.entity.superClass.Sheep;
import com.ovinos.service.CharacteristicsService;
import com.ovinos.service.PregnancyService;
import com.ovinos.service.SheepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/sheep")
public class SheepResource {

    @Autowired
    private SheepService sheepService;

    @Autowired
    private CharacteristicsService characteristicsService;

    @Autowired
    private PregnancyService pregnancyService;

    @GetMapping
    public ResponseEntity<List<Sheep>> findAll(){
        List<Sheep> list = sheepService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Sheep> findById(@PathVariable String id){
        Sheep obj = sheepService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id){
        sheepService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/create-sheep")
    public ResponseEntity<Sheep> createSheep(@RequestBody SheepDTO sheep){
        return ResponseEntity.ok().body(sheepService.createSheep(sheep));
    }

    @PostMapping(value = "/characteristics/{id}")
    public ResponseEntity<Void> addCharacteristics(@PathVariable String id, @RequestBody CharacteristicsDTO characteristicsDTO){
        sheepService.addCharacteristics(id, characteristicsDTO);

        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/race")
    public ResponseEntity<List<RaceSheep>> getAllRace(){
        List<RaceSheep> list = characteristicsService.getAllRace();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/condition/{sex}")
    public ResponseEntity<List<ConditionSheep>> getCondition(@PathVariable SheepSex sex){
        List<ConditionSheep> obj = characteristicsService.getCondition(sex);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping(value = "/status")
    public ResponseEntity<List<SheepStatus>> getStatus(){
        List<SheepStatus> obj = characteristicsService.getStatus();
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping(value = "/treatments/{id}")
    public ResponseEntity<Void> addTreatment(@PathVariable String id, @RequestBody TreatmentDTO treatment){

        sheepService.addTreatment(id, treatment);

        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/treatmentCompleted/{id}")
    public ResponseEntity<Void> treatmentCompleted (@PathVariable String id){
        sheepService.treatmentCompleted(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/pregnancy/{id}")
    public ResponseEntity<Void> addPregnancy(@PathVariable String id, @RequestBody PregnancyDTO pregnancyDTO){
        sheepService.addPregnancy(id , pregnancyDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/pregnancy")
    public ResponseEntity<List<TypeBirth>> getTypeBirth(){
        List<TypeBirth> obj = pregnancyService.getType();
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping(value = "/weight/{id}")
    public ResponseEntity<Void> addWeight(@PathVariable String id, @RequestBody WeightDTO dto){
        sheepService.addWeight(id, dto);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/notes/{id}")
    public ResponseEntity<Void> addNote(@PathVariable String id, @RequestBody NotesDTO dto){
        sheepService.addNote(id, dto);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/activity/{id}")
    public ResponseEntity<Void> addActivity(@PathVariable String id, @RequestBody ActivityDTO dto){
        sheepService.addActivity(id, dto);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/activityCompleted/{id}")
    public ResponseEntity<Void> activityCompleted(@PathVariable String id){
        sheepService.activityCompleted(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/kinship/{id}")
    public ResponseEntity<Void> addKinship(@PathVariable String id, @RequestBody KinshipDTO dto){
        sheepService.addKinship(id, dto);
        return ResponseEntity.noContent().build();
    }
}
