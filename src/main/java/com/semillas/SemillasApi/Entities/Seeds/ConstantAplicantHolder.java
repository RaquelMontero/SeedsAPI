package com.semillas.SemillasApi.Entities.Seeds;


import com.semillas.SemillasApi.Enums.PaymentMethod;
import com.semillas.SemillasApi.Enums.RemainderType;
import com.semillas.SemillasApi.Enums.SendNewsType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConstantAplicantHolder {
    private Contributor contributor;
    private Long contribution_amount;
    private PaymentMethod paymentMethod;
    private SendNewsType sendNewsType;
    private Boolean send_news;
    private String beginMonth;
    private String paymentDay;
    private RemainderType reminderMethod;
}
