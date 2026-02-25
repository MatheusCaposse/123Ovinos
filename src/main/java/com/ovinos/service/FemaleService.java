package com.ovinos.service;

import com.ovinos.entity.Female;
import com.ovinos.repository.FemaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FemaleService {

    @Autowired
    private FemaleRepository repository;

    public List<Female> findAll(){
        List<Female> list = repository.findAll();
        return list;
    }
}
