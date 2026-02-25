package com.ovinos.entity;

import com.ovinos.entity.superClass.Sheep;
import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class Female extends Sheep {

    public Female(){}

    public Female(String id, Date dataNascimento, Double peso) {
        super(id, dataNascimento, peso);
    }
}
