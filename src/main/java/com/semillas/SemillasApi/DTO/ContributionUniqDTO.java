package com.semillas.SemillasApi.DTO;

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
    public String const_contribution_id;
    public String start_month;
    public int paymentDate;
    public RemainderType remainderType;
    public Date contributionStartDate;
    public Date contributionEndDate;
}
