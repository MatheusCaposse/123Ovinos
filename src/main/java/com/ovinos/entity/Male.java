package com.ovinos.entity;

import com.ovinos.entity.superClass.Sheep;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@DiscriminatorValue("M")
public class Male extends Sheep {

    public Male(){}

    public Male(String id, Date dataNascimento, Double peso, Batch batch) {
        super(id, dataNascimento, peso, batch);
    }
}
