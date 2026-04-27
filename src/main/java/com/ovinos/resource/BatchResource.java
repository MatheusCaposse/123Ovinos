package com.ovinos.resource;

import com.ovinos.entity.Batch;
import com.ovinos.entity.Enum.BatchType;
import com.ovinos.repository.BatchRepository;
import com.ovinos.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/batch")
public class BatchResource {

    @Autowired
    private BatchService service;

    @Autowired
    private BatchRepository repository;

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

    @GetMapping(value = "/type")
    public ResponseEntity<List<BatchType>> allTypes(){
        List<BatchType> list = BatchType.getAllTypes();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping(value = "/addBatch")
    public ResponseEntity<Batch> addBatch(@RequestBody Batch batch){
        Batch obj = new Batch(batch.getId(), batch.getBatchType());
        service.insert(obj);
        return ResponseEntity.ok().body(batch);
    }
}
