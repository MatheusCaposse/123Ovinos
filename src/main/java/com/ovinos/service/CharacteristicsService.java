package com.ovinos.service;

import com.ovinos.entity.Enum.ConditionSheep;
import com.ovinos.entity.Enum.RaceSheep;
import com.ovinos.entity.Enum.SheepSex;
import com.ovinos.entity.Enum.SheepStatus;
import com.ovinos.entity.auxiliarData.Characteristics;
import com.ovinos.repository.CharacteristicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CharacteristicsService {

    @Autowired
    private CharacteristicsRepository repository;

    public List<Characteristics> findAll(){
        List<Characteristics> list = repository.findAll();
        return list;
    }

    public List<RaceSheep> getAllRace(){
        List<RaceSheep> list = RaceSheep.getRace();
        return list;
    }

    public List<ConditionSheep> getCondition(SheepSex sex){
        if(sex == SheepSex.MACHO){
            List<ConditionSheep> obj = ConditionSheep.getMaleCodition();
            return obj;
        }else {
            List<ConditionSheep> obj = ConditionSheep.getFemaleCodition();
            return obj;
        }
    }

    public List<SheepStatus> getStatus(){
        List<SheepStatus> obj = SheepStatus.getStatus();
        return obj;
    }
}
