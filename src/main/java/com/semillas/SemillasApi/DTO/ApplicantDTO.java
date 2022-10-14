package com.semillas.SemillasApi.DTO;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.semillas.SemillasApi.Entities.Seeds.Contributor;
import com.semillas.SemillasApi.Enums.ContributorState;
import com.semillas.SemillasApi.Enums.ContributionType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ApplicantDTO {
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
    public ApplicantDTO(Contributor contributor) {
        applicant_id= contributor.getContributor_id();
        name= contributor.getUser().getName()+ contributor.getUser().getLastname();
        lastname= contributor.getUser().getLastname();
        email= contributor.getUser().getEmail();
        phone= contributor.getUser().getPhone();
        dni= contributor.getUser().getDni();
        birthdate= contributor.getUser().getBirthdate();
        address= contributor.getAddress();
        country= contributor.getCountry();
        city= contributor.getCity();
        send_date= contributor.getSend_date();
        //contributorState = contributor.getContributorState();
        contributionConfig_id= contributor.getContributionConfig().getContribution_config_id();
        contributionType= contributor.getContributionConfig().getContributionType();
        //contribution_id= contributor.getContributionConfig().getContribution_id();
    }
}
