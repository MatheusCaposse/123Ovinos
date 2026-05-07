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

    public Deads findById(String id){
        Deads obj = repository.findById(id).orElseThrow(() -> new SheepException("Animal não encontrado"));
        return obj;
    }

    public void addDeadSheep(String id, String nota){
        Sheep obj = sheepRepository.findById(id)
                .orElseThrow(() -> new SheepException("Animal não encontrado"));

        Optional<Deads> dead = repository.findById(obj.getId());

        if(dead.isPresent()){
            throw new SheepException("Esse animal já esta na tabela de Excluidos");
        }
        repository.save(new Deads(obj, nota));
        sheepRepository.delete(obj);

        sheepRepository.delete(obj);
    }

    public void revertDead(String id){
        Deads obj = repository.findById(id).orElseThrow(()-> new SheepException("Esse id não esta na tabela de mortos"));
        if(obj.getSex()==SheepSex.FEMEA){
            Female female = new Female(obj.getId(), obj.getDataNascimento());
            sheepRepository.save(female);
            repository.delete(obj);
        } else {
            Male male = new Male(obj.getId(), obj.getDataNascimento());
            sheepRepository.save(male);
            repository.delete(obj);
        }
    }

}
