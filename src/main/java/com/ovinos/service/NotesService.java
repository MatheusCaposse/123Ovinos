package com.ovinos.service;

import com.ovinos.entity.auxiliarData.Notes;
import com.ovinos.repository.NotesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesService {

    private NotesRepository repository;

    public List<Notes> findAll(){
        List<Notes> list = repository.findAll();
        return list;
    }
}
