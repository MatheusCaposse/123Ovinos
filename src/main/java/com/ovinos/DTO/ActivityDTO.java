package com.ovinos.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ovinos.entity.superClass.Sheep;

import java.time.LocalDate;

public class ActivityDTO {

    private String activity;
    private LocalDate dateActivity;

    public ActivityDTO(){}

    public ActivityDTO(LocalDate dateActivity, String activity) {
        this.dateActivity = dateActivity;
        this.activity = activity;
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
