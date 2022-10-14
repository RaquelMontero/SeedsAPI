package com.semillas.SemillasApi.Entities.Seeds;

import com.semillas.SemillasApi.Enums.PaymentMethod;
import com.semillas.SemillasApi.Enums.SendNewsType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UniqueAplicantHolder {
    private Contributor contributor;
    private Long contribution_amount;
    private PaymentMethod paymentMethod;
    private Boolean send_news;
    private SendNewsType sendNewsType;
    private Date date_contribution;

    //private UniqueContribution uniqueContribution;
}
