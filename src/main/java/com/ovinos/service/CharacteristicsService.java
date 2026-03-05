package com.ovinos.service;

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
}
