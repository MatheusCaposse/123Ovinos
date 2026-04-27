package com.ovinos.entity.Enum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum BatchType {
    RECRIA,
    DESMAME,
    CONFINAMENTO,
    PARTO,
    ENGORDA,
    ENFERMAGEM;


    public static List<BatchType> getAllTypes(){
        List<BatchType> list = new ArrayList<>(Arrays.asList(BatchType.RECRIA, BatchType.DESMAME, BatchType.CONFINAMENTO, BatchType.PARTO, BatchType.ENGORDA, BatchType.ENFERMAGEM));
        return list;
    }
}
