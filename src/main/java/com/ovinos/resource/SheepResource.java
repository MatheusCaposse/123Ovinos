package com.ovinos.resource;

import com.ovinos.entity.superClass.Sheep;
import com.ovinos.service.SheepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
