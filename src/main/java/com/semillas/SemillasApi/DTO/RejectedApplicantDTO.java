package com.semillas.SemillasApi.DTO;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.semillas.SemillasApi.Entities.Seeds.DeactivatedContributor;
import com.semillas.SemillasApi.Enums.ContributorState;
import com.semillas.SemillasApi.Enums.ContributionType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class RejectedApplicantDTO {
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
    private String reason;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date reject_date;
    public RejectedApplicantDTO(DeactivatedContributor applicant) {
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
        contributionType= applicant.getContributor().getContributionConfig().getContributionType();
        //contribution_id=applicant.getContributor().getContributionConfig().getContribution_id();
        //reason=applicant.getReject_reason();
        //reject_date=applicant.getReject_date();
    }
}
