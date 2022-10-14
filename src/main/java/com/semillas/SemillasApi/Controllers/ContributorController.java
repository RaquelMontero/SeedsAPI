package com.semillas.SemillasApi.Controllers;


import com.semillas.SemillasApi.DTO.ContributorDTO;
import com.semillas.SemillasApi.DTO.Format.ComboSeed;
import com.semillas.SemillasApi.DTO.Format.Table;
import com.semillas.SemillasApi.DTO.ProcessSeedDTO;
import com.semillas.SemillasApi.Entities.Filters.ContributorFilter;
import com.semillas.SemillasApi.Entities.ResponseMessage;
import com.semillas.SemillasApi.Entities.Seeds.ConstantAplicantHolder;
import com.semillas.SemillasApi.Entities.Seeds.UniqueAplicantHolder;
import com.semillas.SemillasApi.Service.ContributorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import javax.inject.Inject;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/seeds/applicants")
public class ContributorController {
    @Inject
    ContributorService contributorService;

    @PostMapping(value = "/unique", consumes = "application/json", produces = "application/json")
    public ResponseMessage createUniqueApplicant(@RequestBody UniqueAplicantHolder uniqueAplicantHolder) {
        return contributorService.savUniqueContributtor(uniqueAplicantHolder);
    }

    @PostMapping(value = "/constant", consumes = "application/json", produces = "application/json")
    public ResponseMessage createConstantApplicant(@RequestBody ConstantAplicantHolder constantAplicantHolder) {
        return contributorService.saveConstantContributtor(constantAplicantHolder);
    }


    @PostMapping(value = "/processSeed", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseMessage processAplicant(@RequestBody ProcessSeedDTO processSeedDTO) {
        return contributorService.acceptApplicant(processSeedDTO);
    }

    @GetMapping(path = {"/contributorSeeds/{contributorFilter}"})
    public List<ContributorDTO> findContributorSeeds(@PathVariable ContributorFilter contributorFilter){
        List<ContributorDTO> contributorDTOS= contributorService.findAcceptedApplicants();
        return contributorDTOS;
    }

    @GetMapping(path = {"/acepted"})
    public Table getAceptedSeeds(){
        return contributorService.findAceptedSeeds();
    }

    @GetMapping(path = {"/pending"})
    public Table getAllApplicants(){
        return contributorService.findAllPendingSeeds();
    }

    @GetMapping(path = {"/rejected"})
    public Table getRejectedSeeds(){
        return contributorService.findRejectedSeeds();
    }

    @GetMapping(path = {"/activeseeds"})
    public List<ComboSeed> findActiveSeeds(){
        return contributorService.findActiveSeeds();
    }
}

