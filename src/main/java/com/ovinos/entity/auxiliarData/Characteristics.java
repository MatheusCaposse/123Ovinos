package com.ovinos.entity.auxiliarData;

import com.ovinos.entity.Enum.ConditionSheep;
import com.ovinos.entity.Enum.RaceSheep;
import com.ovinos.entity.Enum.SheepSex;
import com.ovinos.entity.Enum.SheepStatus;
import jakarta.persistence.*;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
public class Characteristics {

    @Enumerated(EnumType.STRING)
    private SheepSex sex;

    @Enumerated(EnumType.STRING)
    private SheepStatus status;

    @Enumerated(EnumType.STRING)
    private ConditionSheep conditionSheep;

    @Enumerated(EnumType.STRING)
    private RaceSheep raceSheep;

    public Characteristics (){}

    public Characteristics(SheepStatus status, ConditionSheep conditionSheep, RaceSheep raceSheep) {
        this.status = status;
        this.conditionSheep = conditionSheep;
        this.raceSheep = raceSheep;
    }

    public SheepSex getSex() {
        return sex;
    }

    public void setSex(SheepSex sex) {
        this.sex = sex;
    }

    public SheepStatus getStatus() {
        return status;
    }

    public void setStatus(SheepStatus status) {
        this.status = status;
    }

    public ConditionSheep getConditionSheep() {
        return conditionSheep;
    }

    public void setConditionSheep(ConditionSheep conditionSheep) {
        this.conditionSheep = conditionSheep;
    }

    public RaceSheep getRaceSheep() {
        return raceSheep;
    }

    public void setRaceSheep(RaceSheep raceSheep) {
        this.raceSheep = raceSheep;
    }
}
