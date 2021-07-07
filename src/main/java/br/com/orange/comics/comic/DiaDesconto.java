package br.com.orange.comics.comic;

import java.time.DayOfWeek;

import static java.time.DayOfWeek.*;

public enum DiaDesconto {

    SEGUNDA_FEIRA, TERCA_FEIRA, QUARTA_FEIRA, QUINTA_FEIRA, SEXTA_FEIRA;

    public static DiaDesconto converteDia(DayOfWeek diaHoje) {
        if (diaHoje.equals(MONDAY)) {
            return SEGUNDA_FEIRA;
        }
        if (diaHoje.equals(TUESDAY)) {
            return TERCA_FEIRA;
        }
        if (diaHoje.equals(WEDNESDAY)) {
            return QUARTA_FEIRA;
        }
        if (diaHoje.equals(THURSDAY)) {
            return QUINTA_FEIRA;
        }
        if (diaHoje.equals(FRIDAY)) {
            return SEXTA_FEIRA;
        } else return null;
    }
}
