package com.semillas.SemillasApi.Entities.Souvenirs;


import com.semillas.SemillasApi.Entities.Seeds.Contributor;
import com.semillas.SemillasApi.Entities.Volunter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "benefited_collaborator")
@Getter
@Setter
public class BenefitedCollaborator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "benefited_collaborator_id")
    private Long benefited_collaborator_id;

    @Column(name = "selected_date")
    private Date selected_date;

    @Column(name = "observation")
    private String observation;

    @Column(name = "city")
    private String city;

    @NotNull(message = "The contributor must not be null")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contributor_id", referencedColumnName = "contributor_id")
    private Contributor contributor;

    @NotNull(message = "The volunter in charge must not be null")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "volunter_in_charge_id", referencedColumnName = "volunter_id")
    private Volunter volunter_in_charge;
}
