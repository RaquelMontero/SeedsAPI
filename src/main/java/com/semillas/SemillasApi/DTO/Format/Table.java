package com.semillas.SemillasApi.DTO.Format;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Table {
    public List<TableRow> rows;

    public Table(List<TableRow> rows) {
        this.rows = rows;
    }
}
