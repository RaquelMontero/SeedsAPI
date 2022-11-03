package com.semillas.SemillasApi.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.semillas.SemillasApi.Enums.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "volunter")
@Getter
@Setter
public class Volunter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "volunter_id")
    private Long volunterId;

    @Column(name = "entry_date")
    private Date entryDate;

    @Column(name = "exit_date")
    private Date exitDate;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @NotNull(message = "The user must not be null")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    //@JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "volunter")
    private Set<ExitMessage> exitMessages = new HashSet<>();

    //@JsonIgnore
    @ManyToMany
    @NotNull(message = "The list of roles may not be empty")
    @JoinTable(name = "volunter_role",
            joinColumns = @JoinColumn(name = "volunter_id", referencedColumnName = "volunter_id"),
            inverseJoinColumns = @JoinColumn(name = "roleId"))
    private List<Role> roles = new ArrayList<>();

}
