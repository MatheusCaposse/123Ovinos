package com.ovinos.DTO;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class WeightDTO {

    SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");

    private Double currentWeight;
    private Double lastWeight;

    private LocalDate currentWeighing = LocalDate.of(2026, 2, 20);
    private LocalDate firstWeighing = LocalDate.of(2026, 2, 13);

    public WeightDTO(Double currentWeight, Double lastWeight, LocalDate currentWeighing, LocalDate lastWeighing) {
        this.currentWeight = currentWeight;
        this.lastWeight = lastWeight;
        this.currentWeighing = currentWeighing;
        this.firstWeighing = lastWeighing;
    }

    public WeightDTO(){}

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

    public LocalDate getCurrentWeighing() {
        return currentWeighing;
    }

    public void setCurrentWeighing(LocalDate currentWeighing) {
        this.currentWeighing = currentWeighing;
    }

    public LocalDate getFirstWeighing() {
        return firstWeighing;
    }

    public void setFirstWeighing(LocalDate firstWeighing) {
        this.firstWeighing = firstWeighing;
    }
}
