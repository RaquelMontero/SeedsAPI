package com.semillas.SemillasApi.Controllers;

import com.semillas.SemillasApi.DTO.ConstantContributionDTO;
import com.semillas.SemillasApi.Entities.Seeds.ConstantContribution;
import com.semillas.SemillasApi.Entities.Seeds.ContributionConfig;
import com.semillas.SemillasApi.Service.ConstantContributionService;
import com.semillas.SemillasApi.Service.ContributionConfigService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/seeds/contribution")
public class ContributionController {
    @Inject
    ConstantContributionService constantContributionService;
    @Inject
    ContributionConfigService contributionConfigService;

    @GetMapping(path = {"/getContributionConfigById"})
    public ContributionConfig findContributionConfigById(@RequestParam(required = true) Long id){
        ContributionConfig contributionConfig=contributionConfigService.getContributionConfigById(id);
        return contributionConfig;
    }
}
