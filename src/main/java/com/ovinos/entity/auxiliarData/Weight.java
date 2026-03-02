package com.ovinos.entity.auxiliarData;

import jakarta.persistence.Embeddable;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Embeddable
public class Weight {

    private Double currentWeight;
    private Double lastWeight;

    private LocalDate currentWeighing = LocalDate.of(2026, 2, 20);
    private LocalDate lastWeighing = LocalDate.of(2026, 2, 13);

    public Weight(){}

    public Weight(Double currentWeight, Double lastWeight) {
        this.currentWeight = currentWeight;
        this.lastWeight = lastWeight;
    }

    public Weight(Double currentWeight, Double lastWeight, LocalDate currentWeighing, LocalDate lastWeighing) {
        this.currentWeighing = currentWeighing;
        this.lastWeighing = lastWeighing;
        this.currentWeight = currentWeight;
        this.lastWeight = lastWeight;
    }

    public Double getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(Double currentWeight) {
        this.currentWeight = currentWeight;
    }

    public Double getLastWeight() {
        return lastWeight;
    }

    public void setLastWeight(Double lastWeight) {
        this.lastWeight = lastWeight;
    }

    public Double getGMC(){
        if (currentWeight == null || lastWeight == null
                || currentWeighing == null || lastWeighing == null) {
            return null;
        }

        long days = ChronoUnit.DAYS.between(lastWeighing, currentWeighing);

        if (days <= 0) {
            return 0.0; // ou lançar exceção
        }

        double weightDifference = currentWeight - lastWeight;

        return Math.round((weightDifference / days) * 1000.0) / 1000.0;
    }
}
