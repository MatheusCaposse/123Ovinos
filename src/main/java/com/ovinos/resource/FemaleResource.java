package com.ovinos.resource;

import com.ovinos.entity.Female;
import com.ovinos.service.FemaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/female")
public class FemaleResource {

    @Autowired
    private FemaleService service;

    @GetMapping
    public ResponseEntity<List<Female>> findAll(){
        List<Female> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
