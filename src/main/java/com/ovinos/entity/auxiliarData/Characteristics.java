package com.ovinos.entity.auxiliarData;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.ovinos.entity.Enum.*;
import com.ovinos.service.exception.SheepException;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
@JsonPropertyOrder({
        "sex",
        "raceSheep",
        "condiitonSheep",
        "status"
})
public class Characteristics {

    @Enumerated(EnumType.STRING)
    private SheepSex sex;

    @Enumerated(EnumType.STRING)
    private SheepStatus status;

    @Enumerated(EnumType.STRING)
    private ConditionSheep conditionSheep;

    @Enumerated(EnumType.STRING)
    private RaceSheep raceSheep;

    public Characteristics(){}

    public Characteristics(SheepSex sex, SheepStatus status, ConditionSheep conditionSheep, RaceSheep raceSheep) {
        this.sex = sex;
        this.status = status;
        setConditionSheep(conditionSheep);
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
        if (!conditionSheep.canBe(this.sex)) {
            throw new SheepException("Status inválido para o sexo informado");
        }
        this.status = status;
    }

    public RaceSheep getRaceSheep() {
        return raceSheep;
    }

    public void setRaceSheep(RaceSheep raceSheep) {
        this.raceSheep = raceSheep;
    }
}
