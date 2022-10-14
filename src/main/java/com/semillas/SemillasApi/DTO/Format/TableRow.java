package com.semillas.SemillasApi.DTO.Format;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TableRow {
    public List<Cell> cells;

    public TableRow(List<Cell> cells) {
        this.cells = cells;
    }
}
