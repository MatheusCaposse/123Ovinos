package com.ovinos.DTO;

import com.ovinos.entity.Enum.Alert;
import com.ovinos.entity.superClass.Sheep;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

public class NotesDTO {

    private String note;
    private Alert alert;

    public NotesDTO(){}

    public NotesDTO(String note, Alert alert) {
        this.note = note;
        this.alert = alert;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Alert getAlert() {
        return alert;
    }

    public void setAlert(Alert alert) {
        this.alert = alert;
    }

}
