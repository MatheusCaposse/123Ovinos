package com.ovinos.entity.superClass;

import jakarta.persistence.*;

import java.util.Date;

@MappedSuperclass
public class Sheep {
    @Id
    private String id;
    private Date dataNascimento;
    private Double peso;

    public Sheep(){}

    public Sheep(String id, Date dataNascimento, Double peso) {
        this.id = id;
        this.dataNascimento = dataNascimento;
        this.peso = (Double) peso;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
