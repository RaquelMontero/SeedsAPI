package com.semillas.SemillasApi.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.semillas.SemillasApi.Entities.Souvenirs.SouvenirTracking;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "comment_record")
@Getter
@Setter
public class CommentRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comment_record_id;

    @NotNull
    @Column
    private String comment;

    @Column(name = "comment_date")
    private Date comment_date;

    /*@JsonIgnore
    @ManyToMany(mappedBy = "comment_record")
    private SouvenirTracking souvenirTracking;*/
    /*
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contribution_id")
    private ProcessedContributor processedContributor;*/
}