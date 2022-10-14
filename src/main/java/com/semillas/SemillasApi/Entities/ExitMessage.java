package com.semillas.SemillasApi.Entities;


import com.semillas.SemillasApi.Enums.RolNombre;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class ExitMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long message_id;

    @NotNull
    @Column
    private String message;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "volunter_id")
    private Volunter volunter;
}
