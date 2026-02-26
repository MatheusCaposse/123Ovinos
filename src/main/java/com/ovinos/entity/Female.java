package com.ovinos.entity;

import com.ovinos.entity.Enum.SheepSex;
import com.ovinos.entity.superClass.Sheep;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@DiscriminatorValue("F")
public class Female extends Sheep {

    public Female(){}

    public Female(String id, Date dataNascimento, Double peso, Batch batch) {
        super(id, dataNascimento, peso, batch);
        setSex(SheepSex.FEMEA);
    }
}
