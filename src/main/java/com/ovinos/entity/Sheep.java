package com.ovinos.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Sheep {
    @Id
    private Long id;
    private Date dataNascimento;
    private Double peso;

    public Sheep(){}

    public Sheep(Long id, Date dataNascimento, Double peso) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
