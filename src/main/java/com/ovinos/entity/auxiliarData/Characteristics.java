package com.ovinos.entity.auxiliarData;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.ovinos.entity.Enum.*;
import com.ovinos.entity.superClass.Sheep;
import com.ovinos.service.exception.SheepException;
import jakarta.persistence.*;

@Entity
@JsonPropertyOrder({
        "raceSheep",
        "condiitonSheep",
        "status"
})
public class Characteristics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "characteristics")
    private Sheep sheep;

    @Enumerated(EnumType.STRING)
    private SheepStatus status;

    @Enumerated(EnumType.STRING)
    private ConditionSheep conditionSheep;

    @Enumerated(EnumType.STRING)
    private RaceSheep raceSheep;

    public Characteristics(){}

    public Characteristics(SheepStatus status, ConditionSheep conditionSheep, RaceSheep raceSheep) {
        this.status = status;
        this.raceSheep = raceSheep;
        this.conditionSheep = conditionSheep;
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

    public RaceSheep getRaceSheep() {
        return raceSheep;
    }

    public void setRaceSheep(RaceSheep raceSheep) {
        this.raceSheep = raceSheep;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    @JsonIgnore
    public Sheep getSheep() {
        return sheep;
    }

    public void setSheep(Sheep sheep) {
        this.sheep = sheep;
    }
}
