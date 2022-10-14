package com.semillas.SemillasApi.Controllers;

import com.semillas.SemillasApi.DTO.ConstantContributionDTO;
import com.semillas.SemillasApi.Entities.Seeds.ConstantContribution;
import com.semillas.SemillasApi.Service.ConstantContributionService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/sem/contribution/constant")
public class ConstantContributionController {
    @Inject
    ConstantContributionService constantContributionService;

    @GetMapping(path = {"/{contribution_id}"})
    public ConstantContributionDTO findConstantContributionById(@PathVariable("contribution_id") Long contribution_id){
        ConstantContribution constantContribution=constantContributionService.findConstantContributionById(contribution_id);
        ConstantContributionDTO constantContributionDTO= new ConstantContributionDTO(constantContribution);
        return constantContributionDTO;
    }
}