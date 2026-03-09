package com.ovinos.service;

import com.ovinos.entity.auxiliarData.Activity;
import com.ovinos.repository.AcitivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {
    @Autowired
    private AcitivityRepository repository;

    public List<Activity> findAll(){
        List<Activity> list = repository.findAll();
        return list;
    }
}
