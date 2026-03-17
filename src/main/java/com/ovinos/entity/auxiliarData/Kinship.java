package com.ovinos.entity.auxiliarData;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ovinos.entity.superClass.Sheep;
import jakarta.persistence.*;

@Entity
public class Kinship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String idPai;
    private String idMae;

    @OneToOne(mappedBy = "kinship")
    private Sheep sheep;


    public Kinship(){}

    public Kinship(String idPai, String idMae) {
        this.idPai = idPai;
        this.idMae = idMae;
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

    public String getIdPai() {
        return idPai;
    }

    public void setIdPai(String idPai) {
        this.idPai = idPai;
    }

    public String getIdMae() {
        return idMae;
    }

    public void setIdMae(String idMae) {
        this.idMae = idMae;
    }
}
