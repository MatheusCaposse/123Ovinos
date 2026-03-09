package com.ovinos.entity.auxiliarData;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ovinos.entity.superClass.Sheep;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "activity")
    private Sheep sheep;

    private String activity;
    private LocalDate dateActivity;

    public Activity(){}

    public Activity(LocalDate dateActivity, String activity) {
        this.dateActivity = dateActivity;
        this.activity = activity;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    @JsonIgnore
    public Sheep getSheep() {
        return sheep;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public LocalDate getDateActivity() {
        return dateActivity;
    }

    public void setDateActivity(LocalDate dateActivity) {
        this.dateActivity = dateActivity;
    }
}
