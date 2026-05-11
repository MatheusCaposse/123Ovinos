package com.ovinos.entity.Enum;

import java.util.Arrays;
import java.util.List;

public enum TypeBirth {
    SIMPLES,
    DUPLO,
    TRIPLO,
    QUADRUPLO,
    CINCOouMAIS;


    public static List<TypeBirth> getTypeBirth(){
        List<TypeBirth> obj = Arrays.asList(SIMPLES,
                DUPLO,
                TRIPLO,
                QUADRUPLO,
                CINCOouMAIS);

        return obj;
    }
}
