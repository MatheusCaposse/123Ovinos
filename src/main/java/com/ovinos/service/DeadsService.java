package com.ovinos.service;

import com.ovinos.entity.Deads;
import com.ovinos.entity.Enum.SheepStatus;
import com.ovinos.entity.superClass.Sheep;
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

    public List<Deads> findAll(){
        List<Deads> list = repository.findAll();
        return list;
    }

    public void addDeadSheep(String id){
        Sheep obj = sheepRepository.findById(id)
                .orElseThrow(() -> new SheepException("Sheep not found"));

        obj.setBatch(null);
        obj.setStatus(SheepStatus.MORTO);

        repository.save(new Deads(obj));

        sheepRepository.save(obj);
    }
}
