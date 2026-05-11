package com.ovinos.entity.Enum;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public enum ConditionSheep {
    RECRIA(SheepSex.MACHO, SheepSex.FEMEA),
    CONFINAMENTO(SheepSex.MACHO, SheepSex.FEMEA),
    MAMANDO(SheepSex.MACHO, SheepSex.FEMEA),

    VAZIA(SheepSex.FEMEA),
    PROTOCOLADA(SheepSex.FEMEA),
    MONTA(SheepSex.FEMEA),
    COBERTA(SheepSex.FEMEA),
    PRENHA(SheepSex.FEMEA),
    ABSORVEU(SheepSex.FEMEA),
    PARIDA(SheepSex.FEMEA),
    ABORTO(SheepSex.FEMEA);

    private final Set<SheepSex> sexosPermitidos;

    ConditionSheep(SheepSex... sexos) {
        this.sexosPermitidos = Set.of(sexos);
    }

    public boolean canBe(SheepSex sex) {
        return sexosPermitidos.contains(sex);
    }

    public static List<ConditionSheep> getFemaleCodition(){
        List<ConditionSheep> list = Arrays.asList(RECRIA,
                CONFINAMENTO,
                MAMANDO,

                VAZIA,
                PROTOCOLADA,
                MONTA,
                COBERTA,
                PRENHA,
                ABSORVEU,
                PARIDA,
                ABORTO);
        return list;
    }

    public static List<ConditionSheep> getMaleCodition(){
        List<ConditionSheep> list = Arrays.asList(RECRIA, CONFINAMENTO, MAMANDO);
        return list;
    }
}
