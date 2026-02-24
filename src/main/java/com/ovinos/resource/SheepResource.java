package com.ovinos.resource;

import com.ovinos.entity.Sheep;
import com.ovinos.repository.SheepRepository;
import com.ovinos.service.SheepService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sheep")
public class SheepResource {

    @Autowired
    private SheepService service;

    @GetMapping
    public ResponseEntity<List<Sheep>> findAll(){
        List<Sheep> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
