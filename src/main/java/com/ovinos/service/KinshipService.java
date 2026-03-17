package com.ovinos.service;

import com.ovinos.repository.KinshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KinshipService {

    @Autowired
    private KinshipRepository repository;
}
