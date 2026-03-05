package com.ovinos.entity.auxiliarData;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ovinos.entity.superClass.Sheep;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Treatment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "treatment")
    private Sheep sheep;

    private String descricao;

    private String medicamento;

    private String dosagem;

    private Date dataAplicacao;

    public Treatment(){}

    public Treatment(String descricao, String medicamento, String dosagem, Date dataAplicacao) {
        this.descricao = descricao;
        this.medicamento = medicamento;
        this.dosagem = dosagem;
        this.dataAplicacao = dataAplicacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public Date getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(Date dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    @JsonIgnore
    public Sheep getSheep() {
        return sheep;
    }

    public void setSheep(Sheep sheep) {
        this.sheep = sheep;
    }
}


