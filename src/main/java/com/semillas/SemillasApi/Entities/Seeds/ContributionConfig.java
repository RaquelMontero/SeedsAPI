package com.semillas.SemillasApi.Entities.Seeds;

import com.semillas.SemillasApi.Entities.Souvenirs.BenefitedCollaborator;
import com.semillas.SemillasApi.Enums.ContributionType;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "contribution_config")
@Getter
@Setter
public class ContributionConfig implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contribution_config_id")
    private Long contribution_config_id;

    @Enumerated(EnumType.STRING)
    @Column(name = "contribution_key")
    private ContributionType contribution_key;

    /*@Column(name = "contribution_id")
    private Long contribution_id;*/

    @NotNull(message = "The contribution id must not be null")
    //@OneToOne(cascade = CascadeType.ALL)
    @Column(name = "contribution_id")
    private Long contribution_id;

    /*@OneToOne(mappedBy = "contribution_config")
    private Contributor contributor;*/

}