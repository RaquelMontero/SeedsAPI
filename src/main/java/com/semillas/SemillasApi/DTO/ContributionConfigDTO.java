package com.semillas.SemillasApi.DTO;

import com.semillas.SemillasApi.Enums.ContributionType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContributionConfigDTO {
    private Long id;
    private ContributionType contribution_key;
    private Long contribution_id ;
    private ContributionDTO contribution;

}
