package com.ovinos.entity.superClass;

import com.ovinos.entity.Batch;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "sexo")
public abstract class Sheep {

    @Id
    private String id;

    private Date dataNascimento;
    private Double peso;

    @ManyToOne
    @JoinColumn(name = "batch_id")
    private Batch batch;

    public Sheep(){}

    public Sheep(String id, Date dataNascimento, Double peso, Batch batch) {
        this.id = id;
        this.dataNascimento = dataNascimento;
        this.peso = (Double) peso;
        this.batch = batch;

        if (batch != null){
            batch.addSheep(this);
        }
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

    public Batch getBatch() {
        return batch;
    }
}
