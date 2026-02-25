package com.ovinos.resource;

import com.ovinos.entity.Female;
import com.ovinos.entity.Male;
import com.ovinos.service.FemaleService;
import com.ovinos.service.MaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/male")
public class MaleResource {

    @Autowired
    private MaleService service;

    @GetMapping
    public ResponseEntity<List<Male>> findAll(){
        List<Male> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
