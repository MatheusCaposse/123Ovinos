package com.ovinos.service;

import com.ovinos.entity.auxiliarData.Pregnancy;
import com.ovinos.repository.PregnancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PregnancyService {

    @Autowired
    private PregnancyRepository repository;

    public List<Pregnancy> findAll(){
        List<Pregnancy> list = repository.findAll();
        return list;
    }
}
