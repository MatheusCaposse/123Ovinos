package com.ovinos.entity;

import com.ovinos.entity.Enum.*;
import com.ovinos.entity.auxiliarData.Pregnancy;
import com.ovinos.entity.superClass.Sheep;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@DiscriminatorValue("F")
public class Female extends Sheep {

    @Embedded
    private Pregnancy pregnancy;

    public Female(){}

    public Female(String id,Date dataNascimento, SheepStatus status, ConditionSheep conditionSheep, RaceSheep raceSheep, Double peso, Batch batch) {
        super(id, SheepSex.FEMEA,dataNascimento,status, conditionSheep , raceSheep,peso, batch);
    }

    public Female(String id,Date dataNascimento, Double peso, Batch batch) {
        super(id, SheepSex.FEMEA,dataNascimento ,peso, batch);
    }

    public Pregnancy getPregnancy() {
        return pregnancy;
    }

    public void setPregnancy(TypeBirth typeBirth, String idPai) {
        this.pregnancy = new Pregnancy(typeBirth, idPai);
    }
}
