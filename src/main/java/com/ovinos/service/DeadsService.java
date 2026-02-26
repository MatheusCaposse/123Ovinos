package com.ovinos.service;

import com.ovinos.entity.Deads;
import com.ovinos.entity.superClass.Sheep;
import com.ovinos.repository.DeadsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeadsService {

    @Autowired
    private DeadsRepository repository;

    public List<Deads> findAll(){
        List<Deads> list = repository.findAll();
        return list;
    }
}
