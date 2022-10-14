package com.semillas.SemillasApi.Enums;

public enum RolName {
    R_PRINCIPAL("Principal"),
    R_REGISTROS("Registros"),
    R_SEGUIMIENTOS("Seguimiento"),
    R_SOUVENIRS("Souvenirs");

    public String value;
    private RolName(String value){
        this.value=value;
    }
}
