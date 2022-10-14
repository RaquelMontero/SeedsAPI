package com.semillas.SemillasApi.DTO;

import com.semillas.SemillasApi.Entities.Seeds.ConstantContribution;
import com.semillas.SemillasApi.Enums.PaymentDate;
import com.semillas.SemillasApi.Enums.PaymentMethod;
import com.semillas.SemillasApi.Enums.RemainderType;
import com.semillas.SemillasApi.Enums.SendNewsType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConstantContributionDTO {
    private Long contribution_id;
    private Long contribution_amount;
    private PaymentMethod paymentMethod;
    private Boolean send_news;
    private SendNewsType sendNewsType;

    private Long const_contribution_id;
    private String start_month;
    private PaymentDate paymentDate;
    private RemainderType remainderType;

    public ConstantContributionDTO(ConstantContribution constantContribution){
        contribution_id=constantContribution.getContribution().getContribution_id();
        contribution_amount=constantContribution.getContribution().getContribution_amount();
        paymentMethod=constantContribution.getContribution().getPaymentMethod();
        send_news=constantContribution.getContribution().getSend_news();
        sendNewsType=constantContribution.getContribution().getSendNewsType();
        const_contribution_id=constantContribution.getConst_contribution_id();
        start_month=constantContribution.getStart_month();
        paymentDate=constantContribution.getPaymentDate();
        remainderType=constantContribution.getRemainderType();
    }
}