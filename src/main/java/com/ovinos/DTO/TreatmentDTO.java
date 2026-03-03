package com.ovinos.DTO;

import java.util.Date;

public class TreatmentDTO {

    private String descricao;

    private String medicamento;

    private String dosagem;

    private Date dataAplicacao;

    public TreatmentDTO(){}

    public TreatmentDTO(String descricao, String medicamento, String dosagem, Date dataAplicacao) {
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
}
