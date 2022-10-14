package com.semillas.SemillasApi.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.semillas.SemillasApi.Enums.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "volunter")
@Getter
@Setter
public class Volunter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "volunter_id")
    private Long volunter_id;

    @Column(name = "entry_date")
    private Date entry_date;

    @Column(name = "exit_date")
    private Date exit_date;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @NotNull(message = "The user must not be null")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "volunter")
    private List<ExitMessage> exitMessages;

    //@JsonIgnore
    @ManyToMany
    @NotNull(message = "The list of roles may not be empty")
    @JoinTable(name = "volunter_role",
            joinColumns = @JoinColumn(name = "volunter_id", referencedColumnName = "volunter_id"),
            inverseJoinColumns = @JoinColumn(name = "roleId"))
    private List<Role> roles = new ArrayList<>();

}
