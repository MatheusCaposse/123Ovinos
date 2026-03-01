package com.ovinos.entity;

import com.ovinos.entity.Enum.ConditionSheep;
import com.ovinos.entity.Enum.SheepSex;
import com.ovinos.entity.Enum.SheepStatus;
import com.ovinos.entity.superClass.Sheep;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@DiscriminatorValue("M")
public class Male extends Sheep {

    public Male(){}

    public Male(String id, Date dataNascimento, SheepStatus status, ConditionSheep conditionSheep, Double peso, Batch batch) {
        super(id, dataNascimento,status, conditionSheep ,peso, batch);
        setSex(SheepSex.MACHO);
    }
}
