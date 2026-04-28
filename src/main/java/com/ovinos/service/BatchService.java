package com.ovinos.service;

import com.ovinos.entity.Batch;
import com.ovinos.repository.BatchRepository;
import com.ovinos.resource.BatchResource;
import com.ovinos.service.exception.BatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BatchService {

    @Autowired
    private BatchRepository repository;

    public List<Batch> findAll() {
        List<Batch> list = repository.findAll();
        return list;
    }

    public Batch findById(String id) {
        Batch obj = repository.findById(id).orElseThrow(() -> new BatchException("Batch not found"));
        return obj;
    }

    public Batch insert(Batch batch) {
        return repository.save(batch);
    }

    public Boolean batchExist(String id) {
        return repository.findById(id).isPresent();
    }

    public String deleteBatch(String id) {

        Optional<Batch> batch = repository.findById(id);
        if (batch.isPresent()) {
            Batch obj = batch.get();
            if (obj.getTotalAnimal() != 0) {
                return "Existe animais atribuidos a esse lote";
            } else {
                repository.delete(obj);
                return "Deletado com sucesso";
            }
        }else {
            return "Não existe lote com esse ID";
        }
    }

}
