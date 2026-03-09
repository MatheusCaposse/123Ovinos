package com.ovinos.entity.auxiliarData;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.ovinos.entity.Enum.Alert;
import com.ovinos.entity.superClass.Sheep;
import jakarta.persistence.*;

@Entity
@JsonPropertyOrder({
        "notes",
        "alert"
})
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @OneToOne(mappedBy = "notes")
    private Sheep sheep;

    private String note;

    @Enumerated(EnumType.STRING)
    private Alert alert;

    public Notes(){}

    public Notes(String note, Alert alert) {
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

    @JsonIgnore
    public Long getId() {
        return id;
    }
}
