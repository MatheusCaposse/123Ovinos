package com.ovinos.entity.Enum;

import java.util.Arrays;
import java.util.List;

public enum SheepStatus {
    DESCONHECIDO,
    VIVO,
    ABATIDO,
    VENDIDO,
    MORTO,
    DOADO,
    DESAPARECIDO;

    public static List<SheepStatus> getStatus(){
        List<SheepStatus> obj = Arrays.asList(DESCONHECIDO,
                VIVO,
                ABATIDO,
                VENDIDO,
                MORTO,
                DOADO,
                DESAPARECIDO);
        return obj;
    }
}


