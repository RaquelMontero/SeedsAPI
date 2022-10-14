package com.semillas.SemillasApi.Controllers;

import com.semillas.SemillasApi.DTO.UniqueContributionDTO;
import com.semillas.SemillasApi.Entities.Seeds.UniqueContribution;
import com.semillas.SemillasApi.Service.UniqueContributionService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/sem/contribution/unique")
public class UniqueContributionController {
    @Inject
    UniqueContributionService uniqueContributionService;

    @GetMapping(path = {"/{contribution_id}"})
    public UniqueContributionDTO findUniqueContributionById(@PathVariable("contribution_id") Long contribution_id){
        UniqueContribution uniqueContribution=uniqueContributionService.findUniqueContributionById(contribution_id);
        UniqueContributionDTO uniqueContributionDTO= new UniqueContributionDTO(uniqueContribution);
        return uniqueContributionDTO;
    }
}