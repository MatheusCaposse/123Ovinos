package com.ovinos.entity;

import com.ovinos.entity.superClass.Sheep;
import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class Male extends Sheep {

    public Male(){}

    public Male(String id, Date dataNascimento, Double peso) {
        super(id, dataNascimento, peso);
    }
}
