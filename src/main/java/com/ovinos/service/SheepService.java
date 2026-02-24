package com.ovinos.service;

import com.ovinos.entity.Sheep;
import com.ovinos.repository.SheepRepository;
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
}
