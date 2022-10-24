package com.semillas.SemillasApi.DTO;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.semillas.SemillasApi.Entities.Seeds.ProcessedContributor;
import com.semillas.SemillasApi.Enums.ContributorState;
import com.semillas.SemillasApi.Enums.ContributionType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ContributorDTO {
    private Long applicant_id;
    private String name;
    private String lastname;
    private String email;
    private String phone;
    private String dni;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthdate;
    private String address;
    private String country;
    private String city;
    private Date send_date;
    private ContributorState contributorState;
    private Long contributionConfig_id;
    private ContributionType contributionType;
    private Long contribution_id;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date acepted_date;

    public ContributorDTO(ProcessedContributor applicant) {
        applicant_id=applicant.getContributor().getContributor_id();
        name=applicant.getContributor().getUser().getName()+" "+applicant.getContributor().getUser().getLastname();
        lastname=applicant.getContributor().getUser().getLastname();
        email=applicant.getContributor().getUser().getEmail();
        phone=applicant.getContributor().getUser().getPhone();
        dni=applicant.getContributor().getUser().getDni();
        birthdate=applicant.getContributor().getUser().getBirthdate();
        address=applicant.getContributor().getAddress();
        country=applicant.getContributor().getCountry();
        city=applicant.getContributor().getCity();
        send_date=applicant.getContributor().getSend_date();
        //contributorState =applicant.getContributor().getContributorState();
        contributionConfig_id=applicant.getContributor().getContributionConfig().getContribution_config_id();
        contributionType= applicant.getContributor().getContributionConfig().getContribution_key();
        //contribution_id=applicant.getContributor().getContributionConfig().getContribution_id();
        //acepted_date=applicant.getAcepted_date();
    }

}
