package com.ovinos.DTO;

public class KinshipDTO {

    private String idPai;
    private String idMae;

    public KinshipDTO(){}

    public KinshipDTO(String idPai, String idMae) {
        this.idPai = idPai;
        this.idMae = idMae;
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
