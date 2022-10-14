package com.semillas.SemillasApi.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.semillas.SemillasApi.Entities.Role;
import com.semillas.SemillasApi.Entities.Volunter;
import com.semillas.SemillasApi.Enums.Status;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class VolunterDTO {

    private Long volunter_id;
    private Long personId;

    private String name;

    private String lastname;

    private String email;

    private String phone;

    private String dni;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthdate;

    private Date entry_date;

    private Date exit_date;

    private Status status;

    private List<Role> roles;

    public VolunterDTO(Volunter volunter) {

        volunter_id=volunter.getVolunter_id();
        entry_date=volunter.getEntry_date();
        exit_date=volunter.getExit_date();
        status=volunter.getStatus();
        name=volunter.getUser().getName();
        lastname=volunter.getUser().getLastname();
        email=volunter.getUser().getEmail();
        phone=volunter.getUser().getPhone();
        dni=volunter.getUser().getDni();
        birthdate=volunter.getUser().getBirthdate();
        roles=volunter.getRoles();
        personId=volunter.getUser().getUserId();
    }
}
