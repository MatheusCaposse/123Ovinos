package com.ovinos.resource;

import com.ovinos.entity.Deads;
import com.ovinos.service.DeadsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/deads")
public class DeadsResource {

    @Autowired
    private DeadsService service;

    @GetMapping
    public ResponseEntity<List<Deads>> findAll(){
        List<Deads> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/addDead/{id}")
    public ResponseEntity<Void> addDeadSheep(@PathVariable String id){
       service.addDeadSheep(id);
       return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/revertDead/{id}")
    public ResponseEntity<Void> revertDeadSheep(@PathVariable String id){
        service.revertDeadSheep(id);
        return ResponseEntity.noContent().build();
    }
}
