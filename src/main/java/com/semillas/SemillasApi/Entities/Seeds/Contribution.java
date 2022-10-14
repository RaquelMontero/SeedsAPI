package com.semillas.SemillasApi.Entities.Seeds;


import com.semillas.SemillasApi.Enums.PaymentMethod;
import com.semillas.SemillasApi.Enums.SendNewsType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "contribution")
@Getter
@Setter
public class Contribution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contribution_id")
    private Long contribution_id;

    @Column(name = "contribution_amount")
    private Long contribution_amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "paymentMethod")
    private PaymentMethod paymentMethod;

    @Column(name = "send_news")
    private Boolean send_news;

    @Enumerated(EnumType.STRING)
    @Column(name = "send_news_method")
    private SendNewsType sendNewsType;

    @OneToOne(mappedBy = "contribution")
    private ConstantContribution constantContribution;

    @OneToOne(mappedBy = "contribution")
    private UniqueContribution uniqueContribution;

    public Contribution(Long contribution_amount, PaymentMethod paymentMethod, Boolean send_news, SendNewsType sendNewsType) {
        this.contribution_amount = contribution_amount;
        this.paymentMethod = paymentMethod;
        this.send_news = send_news;
        this.sendNewsType = sendNewsType;
        this.constantContribution = constantContribution;
        this.uniqueContribution = uniqueContribution;
    }
}