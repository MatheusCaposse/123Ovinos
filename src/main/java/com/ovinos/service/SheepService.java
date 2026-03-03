package com.ovinos.service;

import com.ovinos.DTO.CharacteristicsDTO;
import com.ovinos.DTO.TreatmentDTO;
import com.ovinos.entity.Enum.SheepStatus;
import com.ovinos.entity.auxiliarData.Treatment;
import com.ovinos.entity.superClass.Sheep;
import com.ovinos.repository.SheepRepository;
import com.ovinos.service.exception.SheepException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SheepService {

    @Autowired
    private SheepRepository repository;

    public List<Sheep> findAll(){
        List<Sheep> list = repository.findAll();
        return list;
    }

    public Sheep findById(String id){
        Sheep obj = repository.findById(id).orElseThrow(() -> new SheepException("Sheep not found"));
        return obj;
    }

    public void addCharacteristics(String id, CharacteristicsDTO characteristicsDTO){
        Sheep sheep = repository.findById(id).orElseThrow(() -> new SheepException("Sheep not found"));

        sheep.setCharacteristics(characteristicsDTO.getSex(), characteristicsDTO.getStatus(), characteristicsDTO.getConditionSheep(), characteristicsDTO.getRaceSheep());

        repository.save(sheep);
    }

    public void addTreatment(String id, TreatmentDTO treatmentDTO){
        Sheep sheep = repository.findById(id).orElseThrow(()-> new SheepException("Sheep not found"));

        sheep.setTreatment(treatmentDTO.getDescricao(), treatmentDTO.getMedicamento(), treatmentDTO.getDosagem());

        repository.save(sheep);
    }
}
