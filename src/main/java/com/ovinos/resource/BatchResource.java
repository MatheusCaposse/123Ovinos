package com.ovinos.resource;

import com.ovinos.entity.Batch;
import com.ovinos.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/batch")
public class BatchResource {

    @Autowired
    private BatchService service;

    @GetMapping
    public ResponseEntity<List<Batch>> findAll(){
        List<Batch> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Batch> findById(@PathVariable String id){
        Batch obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
