package com.ovinos.resource;

import com.ovinos.DTO.TreatmentDTO;
import com.ovinos.entity.Enum.ConditionSheep;
import com.ovinos.entity.Enum.SheepSex;
import com.ovinos.entity.Enum.SheepStatus;
import com.ovinos.entity.auxiliarData.Treatment;
import com.ovinos.entity.superClass.Sheep;
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
    private SheepService service;

    @GetMapping
    public ResponseEntity<List<Sheep>> findAll(){
        List<Sheep> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Sheep> findById(@PathVariable String id){
        Sheep obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/status/{sex}")
    public List<ConditionSheep> getStatusBySex(@PathVariable SheepSex sex) {
        return Arrays.stream(ConditionSheep.values())
                .filter(status -> status.canBe(sex))
                .toList();
    }

    @PostMapping(value = "/{id}/treatments")
    public ResponseEntity<Void> addTreatment(@PathVariable String id, @RequestBody TreatmentDTO treatment){

        service.addTreatment(id, treatment);

        return ResponseEntity.noContent().build();
    }
}
