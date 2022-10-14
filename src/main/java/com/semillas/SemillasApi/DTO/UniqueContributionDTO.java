package com.semillas.SemillasApi.DTO;

import com.semillas.SemillasApi.Entities.Seeds.UniqueContribution;
import com.semillas.SemillasApi.Enums.PaymentMethod;
import com.semillas.SemillasApi.Enums.SendNewsType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UniqueContributionDTO {
    private Long contribution_id;
    private Long contribution_amount;
    private PaymentMethod paymentMethod;
    private Boolean send_news;
    private SendNewsType sendNewsType;
    private Long unique_contribution_id;
    private Date date_contribution;


    public UniqueContributionDTO(UniqueContribution uniqueContribution){
        contribution_id=uniqueContribution.getContribution().getContribution_id();
        contribution_amount=uniqueContribution.getContribution().getContribution_amount();
        paymentMethod=uniqueContribution.getContribution().getPaymentMethod();
        send_news=uniqueContribution.getContribution().getSend_news();
        sendNewsType=uniqueContribution.getContribution().getSendNewsType();
        unique_contribution_id=uniqueContribution.getUnique_contribution_id();
        date_contribution=uniqueContribution.getDate_contribution();
    }
}