package com.semillas.SemillasApi.Controllers;


import com.semillas.SemillasApi.DTO.Format.ExitPost;
import com.semillas.SemillasApi.DTO.Format.Table;
import com.semillas.SemillasApi.DTO.VolunterDTO;
import com.semillas.SemillasApi.Entities.Role;
import com.semillas.SemillasApi.Entities.Volunter;
import com.semillas.SemillasApi.Enums.Status;
import com.semillas.SemillasApi.Service.RoleService;
import com.semillas.SemillasApi.Service.VolunterService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/seeds/volunters")
public class VolunterController {
    @Inject
    VolunterService volunterService;

    @Inject
    RoleService roleService;

    @PostMapping(path = {"/create"})
    @ResponseStatus(HttpStatus.CREATED)
    public void createVolunter(@RequestBody Volunter volunter) {
        System.out.println("llego aqui" + volunter);
        volunterService.saveVolunter(volunter);
    }

    @GetMapping(path = {"/all"})
    public Table findAllVolunters() {
        return volunterService.findAllVolunter();
    }

    @GetMapping(path = {"/getRoles"})
    public List<Role> findVolunterRoles(@RequestBody String email) {
        List<Role> roles = new ArrayList<>();
        Volunter volunter = volunterService.findVolunterRoles(email);
        roles = volunter.getRoles();
        System.out.println("roles controller " + roles.size());
        return roles;
    }

    @GetMapping(path = {"/exitvolunters"})
    public List<VolunterDTO> findAllExitvolunters() {
        List<VolunterDTO> voluntersDTOS = new ArrayList<>();
        return voluntersDTOS;
    }

    @GetMapping(path = {"/getVolunter"})
    public VolunterDTO listarId(@RequestParam(required = true) Long id) {
        VolunterDTO volunterDTO = new VolunterDTO(volunterService.findOneVolunter(id));
        return volunterDTO;
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVolunterById(@PathVariable Long id) {
        volunterService.deleteVolunter(id);
    }

    @PostMapping(value = "/exit")
    @ResponseStatus(HttpStatus.CREATED)
    public void exitVolunterById(@RequestBody ExitPost exitPost) {
        volunterService.exitVolunter(exitPost.getId());
    }

    @PutMapping(value = "return/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void returnVolunterById(@PathVariable Long id) {
        volunterService.getVolunterById(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateVolunterById(@Valid @PathVariable Long id, @RequestBody Volunter volunter) {
        volunterService.updateVolunter(volunter);
    }

    @GetMapping(path = {"/trackingVolunters"})
    public Table gettrackingVolunters(){
        return volunterService.findAlltrackingVolunters();
    }
}