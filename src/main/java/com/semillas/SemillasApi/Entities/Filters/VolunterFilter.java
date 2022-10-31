package com.semillas.SemillasApi.Entities.Filters;

import com.semillas.SemillasApi.Enums.RolName;
import com.semillas.SemillasApi.Enums.Status;
import lombok.Getter;

@Getter
public class VolunterFilter {
    public Status status;
    public RolName roleId;
}
