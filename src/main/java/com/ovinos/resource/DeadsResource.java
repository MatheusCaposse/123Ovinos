package com.ovinos.resource;

import com.ovinos.entity.Deads;
import com.ovinos.service.DeadsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/{id}")
    public ResponseEntity<Deads> findById(@PathVariable String id){
        Deads obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/addDead/{id}/{nota}")
    public ResponseEntity<Void> addDeadSheep(@PathVariable String id, @PathVariable String nota){

       service.addDeadSheep(id, nota);
       return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/revertDead/{id}")
    public ResponseEntity<Void> addDeadSheep(@PathVariable String id){
        service.revertDead(id);
        return ResponseEntity.noContent().build();
    }


}
