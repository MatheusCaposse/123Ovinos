package com.ovinos.service;

import com.ovinos.entity.Batch;
import com.ovinos.entity.Deads;
import com.ovinos.entity.Enum.SheepSex;
import com.ovinos.entity.Enum.SheepStatus;
import com.ovinos.entity.Female;
import com.ovinos.entity.Male;
import com.ovinos.entity.superClass.Sheep;
import com.ovinos.repository.BatchRepository;
import com.ovinos.repository.DeadsRepository;
import com.ovinos.repository.SheepRepository;
import com.ovinos.service.exception.SheepException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeadsService {

    @Autowired
    private DeadsRepository repository;

    @Autowired
    private SheepRepository sheepRepository;

    @Autowired
    private BatchRepository batchRepository;

    public List<Deads> findAll(){
        List<Deads> list = repository.findAll();
        return list;
    }

    public void addDeadSheep(String id){
        Sheep obj = sheepRepository.findById(id)
                .orElseThrow(() -> new SheepException("Sheep not found"));

        Optional<Deads> dead = repository.findById(obj.getId());

        if(dead.isPresent()){
            throw new SheepException("This sheep already in Deads table");
        }
        repository.save(new Deads(obj));

        sheepRepository.delete(obj);
    }

    public void revertDeadSheep(String id){
        Deads obj = repository.findById(id)
                .orElseThrow(() -> new SheepException("Sheep not found"));

        Optional<Deads> dead = repository.findById(obj.getId());

        Batch oldBatch = obj.getBatch();

        if(dead.isEmpty()){
            throw new SheepException("This sheep is not in Deads table");
        }

        if (obj.getSex() == SheepSex.FEMEA){
            Female sheep = new Female(obj.getId(), obj.getDataNascimento(), obj.getLastStatus(), obj.getPeso(), oldBatch);
            sheepRepository.save(sheep);
        }
        else {
            Male sheep = new Male(obj.getId(), obj.getDataNascimento(), obj.getLastStatus(), obj.getPeso(), oldBatch);
            sheepRepository.save(sheep);
        }
        repository.delete(obj);
    }
}
