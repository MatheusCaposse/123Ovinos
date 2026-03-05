package com.ovinos.entity.auxiliarData;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ovinos.entity.superClass.Sheep;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
public class Weight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "weight")
    private Sheep sheep;

    private Double currentWeight;
    private Double lastWeight;

    private LocalDate currentWeighing = LocalDate.of(2026, 2, 20);
    private LocalDate firstWeighing = LocalDate.of(2026, 2, 13);

    public Weight(){}

    public Weight(Double currentWeight, Double lastWeight) {
        this.currentWeight = currentWeight;
        this.lastWeight = lastWeight;
    }

    public Weight(Double currentWeight, Double lastWeight, LocalDate currentWeighing, LocalDate lastWeighing) {
        this.currentWeighing = currentWeighing;
        this.firstWeighing = lastWeighing;
        this.currentWeight = currentWeight;
        this.lastWeight = lastWeight;
    }

    public Double getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(Double currentWeight) {
        this.currentWeight = currentWeight;
    }

    @JsonIgnore
    public Double getLastWeight() {
        return lastWeight;
    }

    public void setLastWeight(Double lastWeight) {
        this.lastWeight = lastWeight;
    }

    public Double getGMD(){
        if (currentWeight == null || lastWeight == null
                || currentWeighing == null || firstWeighing == null) {
            return null;
        }

        long days = ChronoUnit.DAYS.between(firstWeighing, currentWeighing);

        if (days <= 0) {
            return 0.0;
        }

        double weightDifference = currentWeight - lastWeight;

        return Math.round((weightDifference / days) * 1000.0) / 1000.0;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonIgnore
    public Sheep getSheep() {
        return sheep;
    }

    public void setSheep(Sheep sheep) {
        this.sheep = sheep;
    }


    public LocalDate getCurrentWeighing() {
        return currentWeighing;
    }

    public void setCurrentWeighing(LocalDate currentWeighing) {
        this.currentWeighing = currentWeighing;
    }

    @JsonIgnore
    public LocalDate getFirstWeighing() {
        return firstWeighing;
    }

    public void setFirstWeighing(LocalDate firstWeighing) {
        this.firstWeighing = firstWeighing;
    }

}
