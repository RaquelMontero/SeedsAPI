package com.semillas.SemillasApi.Service;


import com.semillas.SemillasApi.Entities.Seeds.ConstantContribution;
import com.semillas.SemillasApi.Entities.Seeds.ContributionConfig;
import com.semillas.SemillasApi.Entities.Seeds.UniqueContribution;
import com.semillas.SemillasApi.Enums.ContributionType;
import com.semillas.SemillasApi.Repository.ConstantContributionRepository;
import com.semillas.SemillasApi.Repository.ContributionConfigRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class ContributionConfigService {
    @Inject
    ContributionConfigRepository contributionConfigRepository;
    @Inject
    ConstantContributionRepository constantContributionRepository;
    @Inject
    UniqueContributionService uniqueContributionService;

    public ContributionConfig saveUniqueContributionConfig(UniqueContribution uniqueContribution){
        UniqueContribution contribution=uniqueContributionService.saveUniqueContribution(uniqueContribution);
        ContributionConfig contributionConfig=new ContributionConfig();
        //contributionConfig.setContribution_id(contribution.getUnique_contribution_id());
        contributionConfig.setContributionType(ContributionType.APORTE_UNICO);
        return contributionConfigRepository.save(contributionConfig);
    }

    public ContributionConfig saveConstantContributionConfig(ConstantContribution constantContribution){
        ConstantContribution contribution=constantContributionRepository.save(constantContribution);

        ContributionConfig contributionConfig=new ContributionConfig();
        //contributionConfig.setContribution_id(contribution.getConst_contribution_id());
        contributionConfig.setContributionType(ContributionType.APORTE_CONSTANTE);
        return contributionConfigRepository.save(contributionConfig);
    }
}