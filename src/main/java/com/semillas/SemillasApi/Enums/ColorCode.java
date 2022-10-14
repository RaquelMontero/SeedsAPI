package com.semillas.SemillasApi.Enums;

import lombok.Getter;

public enum ColorCode {
    EDIT("#8B9068"),
    DELETE("#DB4035"),
    VIEW("#AFB83B"),
    EDIT_ROLES( "FF9933"),
    R_PRINCIPAL_COLOR( "#000033"),
    R_SEGUIMIENTOS_COLOR( "#e0b51c"),
    R_SOUVENIRS_COLOR( "#383a5e"),
    R_REGISTROS_COLOR("#336666"),
    STATE_PENDING("#e7d042"),
    STATE_ACEPTED("#6db669"),
    STATE_REJECTED("#bd5533"),
    ACCEPT_CONTR("#5c9254"),
    REJECT_CONTR("#db504a"),
    VIEW_CONTR("#ffe599"),
    VIEW_ASSIGNED_SEEDS("#88cc77"),
    ASSIGN_SEED("#dead22");
    public String value;
    private ColorCode(String value){
        this.value=value;
    }
}
