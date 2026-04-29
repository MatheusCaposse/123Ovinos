package com.ovinos.DTO;

public class BatchInfoDTO {

    private int totalBatch;
    private String loteComMaisAnimais;
    private String loteComMenosAnimais;

    public BatchInfoDTO(int totalBatch, String loteComMaisAnimais, String loteComMenosAnimais) {
        this.totalBatch = totalBatch;
        this.loteComMaisAnimais = loteComMaisAnimais;
        this.loteComMenosAnimais = loteComMenosAnimais;
    }

    public int getTotalBatch() {
        return totalBatch;
    }

    public String getLoteComMaisAnimais() {
        return loteComMaisAnimais;
    }

    public String getLoteComMenosAnimais() {
        return loteComMenosAnimais;
    }
}
