package com.semillas.SemillasApi.Controllers;

import com.semillas.SemillasApi.DTO.ApplicantDTO;
import com.semillas.SemillasApi.Entities.Role;
import com.semillas.SemillasApi.Service.RoleService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.nio.file.Path;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/seeds/domainhelper")
public class DomainHelperController {
    @Inject
    RoleService roleService;
    @GetMapping(path = {"/roles"})
    public List<Role> findAllApplicants(){
        return roleService.getRoles();
    }
}
