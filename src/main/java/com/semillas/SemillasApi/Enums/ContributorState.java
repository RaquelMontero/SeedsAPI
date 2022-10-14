package com.semillas.SemillasApi.Enums;

import lombok.Getter;

@Getter
public enum ContributorState {
    ACEPTADO(1),
    RECHAZADO(2),
    PENDIENTE(3);

    public int value;
    private ContributorState(int value){
        this.value=value;
    }
}