package com.semillas.SemillasApi.DTO;

import com.semillas.SemillasApi.Entities.Seeds.ContributionConfig;
import com.semillas.SemillasApi.Enums.ContributionType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ContributionConfigDTO {
    private Long id;
    private ContributionType contribution_key;
    private Date register_date ;
    private ContributionDTO contribution;
    private Boolean is_active;
    public ContributionConfigDTO(ContributionConfig contributionConfig) {
        this.id = contributionConfig.getContribution_config_id();
        this.contribution_key = contributionConfig.getContribution_key();
        this.register_date = contributionConfig.getRegister_date();
        this.is_active = contributionConfig.getIs_active();
    }
}
