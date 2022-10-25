package com.semillas.SemillasApi.DTO;

import com.semillas.SemillasApi.Enums.PaymentMethod;
import com.semillas.SemillasApi.Enums.RemainderType;
import com.semillas.SemillasApi.Enums.SendNewsType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ContributionConstDTO implements ContributionDTO {
    public Long contribution_id;
    public Long contribution_amount;
    public PaymentMethod paymentMethod;
    public Boolean send_news;
    public SendNewsType sendNewsType;
    public String const_contribution_id;
    public String start_month;
    public int paymentDate;
    public RemainderType remainderType;
    public Date contributionStartDate;
    public Date contributionEndDate;

    public ContributionConstDTO(Long contribution_id, Long contribution_amount, PaymentMethod paymentMethod, Boolean send_news, SendNewsType sendNewsType, String const_contribution_id, String start_month, int paymentDate, RemainderType remainderType, Date contributionStartDate, Date contributionEndDate) {
        this.contribution_id = contribution_id;
        this.contribution_amount = contribution_amount;
        this.paymentMethod = paymentMethod;
        this.send_news = send_news;
        this.sendNewsType = sendNewsType;
        this.const_contribution_id = const_contribution_id;
        this.start_month = start_month;
        this.paymentDate = paymentDate;
        this.remainderType = remainderType;
        this.contributionStartDate = contributionStartDate;
        this.contributionEndDate = contributionEndDate;
    }

    public ContributionConstDTO() {
    }
}
