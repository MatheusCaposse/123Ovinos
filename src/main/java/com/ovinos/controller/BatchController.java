package com.ovinos.controller;

import com.ovinos.DTO.BatchInfoDTO;
import com.ovinos.DTO.UpdateBatchDTO;
import com.ovinos.entity.Batch;
import com.ovinos.entity.Enum.BatchType;
import com.ovinos.repository.BatchRepository;
import com.ovinos.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/batch")
public class BatchController {

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

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody UpdateBatchDTO obj){
        service.updateBatch(obj);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/infoBatch")
    public ResponseEntity<BatchInfoDTO> infoBatch(){
        BatchInfoDTO obj = service.infoBatch();
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/type")
    public ResponseEntity<List<BatchType>> allTypes(){
        List<BatchType> list = BatchType.getAllTypes();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping(value = "/addBatch")
    public ResponseEntity<?> addBatch(@RequestBody Batch batch){
            if(!service.batchExist(batch.getId())){
                Batch obj = new Batch(batch.getId(), batch.getBatchType());
                service.insert(obj);
                return ResponseEntity.ok().body(batch);
            } else{
                return ResponseEntity.badRequest().body(Map.of("message", "Já existe um lote com esse ID"));
            }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteBatch(@PathVariable String id){
        String resultado = service.deleteBatch(id);
        if(resultado.equals("Deletado com sucesso")){
            return ResponseEntity.ok().body(Map.of("message", resultado));
        }else{
            return ResponseEntity.badRequest().body(Map.of("message", resultado));
        }
    }

    @PutMapping(value = "/addAnimal/{idBatch}/{idSheep}")
    public ResponseEntity<?> addAnimal(@PathVariable String idBatch, @PathVariable String idSheep){
        String resultado = service.addAnimal(idBatch, idSheep);
        if(resultado.equals("Animal adicionado ao lote com sucesso")){
           return ResponseEntity.ok().body(Map.of("message", resultado));
        } else{
            return ResponseEntity.badRequest().body(Map.of("message", resultado));
        }
    }

    @GetMapping(value = "/allBatch")
    public ResponseEntity<List<String>> getAllBatch(){
        List<String> list = service.findAllBatch();
        return ResponseEntity.ok().body(list);
    }
}
