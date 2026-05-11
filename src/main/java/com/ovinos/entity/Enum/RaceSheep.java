package com.ovinos.entity.Enum;

import java.util.Arrays;
import java.util.List;

public enum RaceSheep {
    TEXEL,
    ILLE_DE_FRANCE,
    FINSHEEP,
    EAST_FRIESIAN,
    LACAUNE,
    DORPER,
    SANTA_INES,
    SUFOLK,
    POLL_DORSET,
    CORREDALE,
    HAMPSHIRE;

    public static List<RaceSheep> getRace(){
        List<RaceSheep> list = Arrays.asList(TEXEL,
                ILLE_DE_FRANCE,
                FINSHEEP,
                EAST_FRIESIAN,
                LACAUNE,
                DORPER,
                SANTA_INES,
                SUFOLK,
                POLL_DORSET,
                CORREDALE,
                HAMPSHIRE);

        return list;
    }
}
