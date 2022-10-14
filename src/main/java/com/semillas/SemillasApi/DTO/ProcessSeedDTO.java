package com.semillas.SemillasApi.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class ProcessSeedDTO {

    private Long processed_contributor_id;

    private Long contributor_id;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date processed_date;

    private String process_reason;

    private Long processVolunterId;

    private int state;

    public ProcessSeedDTO(Long processed_contributor_id, Long contributor_id, Date processed_date, String process_reason, Long processVolunterId, int state) {
        this.processed_contributor_id = processed_contributor_id;
        this.contributor_id = contributor_id;
        this.processed_date = processed_date;
        this.process_reason = process_reason;
        this.processVolunterId = processVolunterId;
        this.state = state;
    }
}
