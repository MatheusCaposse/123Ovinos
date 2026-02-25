package com.ovinos.service;

import com.ovinos.entity.Female;
import com.ovinos.entity.Male;
import com.ovinos.repository.FemaleRepository;
import com.ovinos.repository.MaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaleService {

    @Autowired
    private MaleRepository repository;

    public List<Male> findAll(){
        List<Male> list = repository.findAll();
        return list;
    }
}
