package com.semillas.SemillasApi.DTO.Format;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CellParam {
    public String paramName;
    public String paramContent;

    public CellParam(String paramName, String paramContent) {
        this.paramName = paramName;
        this.paramContent = paramContent;
    }
}
