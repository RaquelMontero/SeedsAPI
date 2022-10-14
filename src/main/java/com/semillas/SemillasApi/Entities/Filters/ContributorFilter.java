package com.semillas.SemillasApi.Entities.Filters;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.util.Date;

@Getter
public class ContributorFilter {

    private Long state;

    private Date sendDate;

    private Date beginSendDate;

    private Date endSendDate;

    private String name;

    private Long dni;
}
