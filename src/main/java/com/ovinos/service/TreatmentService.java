package com.ovinos.service;

import com.ovinos.entity.auxiliarData.Treatment;
import com.ovinos.repository.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreatmentService {

    @Autowired
    private TreatmentRepository repository;

    public List<Treatment> findAll(){
        List<Treatment> obj = repository.findAll();
        return obj;
    }
}
