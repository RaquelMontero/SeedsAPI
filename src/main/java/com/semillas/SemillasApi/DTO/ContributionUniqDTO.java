package com.semillas.SemillasApi.DTO;

import com.semillas.SemillasApi.Entities.Seeds.UniqueContribution;
import com.semillas.SemillasApi.Enums.PaymentMethod;
import com.semillas.SemillasApi.Enums.RemainderType;
import com.semillas.SemillasApi.Enums.SendNewsType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ContributionUniqDTO implements ContributionDTO{
    public Long contribution_id;
    public Long contribution_amount;
    public PaymentMethod paymentMethod;
    public Boolean send_news;
    public SendNewsType sendNewsType;

    public String unique_contribution_id;
    public Date date_contribution;

    public ContributionUniqDTO(UniqueContribution uniqueContribution) {
        this.contribution_id = uniqueContribution.getContribution().getContribution_id();
        this.contribution_amount = uniqueContribution.getContribution().getContribution_amount();
        this.paymentMethod = uniqueContribution.getContribution().getPaymentMethod();
        this.send_news = uniqueContribution.getContribution().getSend_news();
        this.sendNewsType = uniqueContribution.getContribution().getSendNewsType();

        this.unique_contribution_id = uniqueContribution.getUnique_contribution_id().toString();
        this.date_contribution = uniqueContribution.getDate_contribution();
    }
}
