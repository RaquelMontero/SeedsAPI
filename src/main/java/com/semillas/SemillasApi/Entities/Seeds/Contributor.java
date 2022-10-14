package com.semillas.SemillasApi.Entities.Seeds;

import com.semillas.SemillasApi.Entities.User;
import com.semillas.SemillasApi.Entities.Volunter;
import com.semillas.SemillasApi.Enums.ContributorState;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "contributor")
@Getter
@Setter
public class Contributor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contributor_id")
    private Long contributor_id;

    @Column(name = "address")
    private String address;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "send_date")
    private Date send_date;

    @NotNull(message = "The register volunter must not be null")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "register_volunter_id", referencedColumnName = "volunter_id")
    private Volunter registerVolunter;

    //@Enumerated(EnumType.STRING)
    @Column(name = "contributor_state")
    private Long contributorState;

    @NotNull(message = "The person must not be null")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @NotNull(message = "The Config must not be null")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contribution_config_id", referencedColumnName = "contribution_config_id")
    private ContributionConfig contributionConfig;

    @OneToOne(mappedBy = "contributor")
    private DeactivatedContributor deactivatedContributor;

    @OneToOne(mappedBy = "contributor")
    private ProcessedContributor processedContributor;
}