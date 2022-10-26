package com.semillas.SemillasApi.Service;


import com.semillas.SemillasApi.Entities.Seeds.ConstantContribution;
import com.semillas.SemillasApi.Entities.Seeds.ContributionConfig;
import com.semillas.SemillasApi.Entities.Seeds.UniqueContribution;
import com.semillas.SemillasApi.Enums.ContributionType;
import com.semillas.SemillasApi.Repository.ConstantContributionRepository;
import com.semillas.SemillasApi.Repository.ContributionConfigRepository;
import com.semillas.SemillasApi.Repository.UniqueContributionRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Optional;

@Service
public class ContributionConfigService {
    @Inject
    ContributionConfigRepository contributionConfigRepository;
    @Inject
    ConstantContributionRepository constantContributionRepository;
    @Inject
    UniqueContributionRepository uniqueContributionRepository;
    @Inject
    UniqueContributionService uniqueContributionService;

    public ContributionConfig saveUniqueContributionConfig(UniqueContribution uniqueContribution){
        UniqueContribution contribution=uniqueContributionService.saveUniqueContribution(uniqueContribution);
        ContributionConfig contributionConfig=new ContributionConfig();
        //contributionConfig.setContribution_id(contribution.getUnique_contribution_id());
        contributionConfig.setContribution_key(ContributionType.APORTE_UNICO);
        return contributionConfigRepository.save(contributionConfig);
    }

    public ContributionConfig saveConstantContributionConfig(ConstantContribution constantContribution){
        ConstantContribution contribution=constantContributionRepository.save(constantContribution);
        ContributionConfig contributionConfig=new ContributionConfig();
        contributionConfig.setConstantContribution(contribution);
        contributionConfig.setIs_active(true);
        contributionConfig.setContribution_key(ContributionType.APORTE_CONSTANTE);
        return contributionConfigRepository.save(contributionConfig);
    }

    public ContributionConfig getContributionConfigById(Long id){
        Optional<ContributionConfig> contributionConfig = contributionConfigRepository.findById(id);
        if (contributionConfig.get().getContribution_key().equals(ContributionType.APORTE_CONSTANTE)){
            Optional<ConstantContribution> constantContribution = constantContributionRepository.findById(
                    contributionConfig.get().getConstantContribution().getConst_contribution_id());
        }
        else{
            Optional<UniqueContribution> constantContribution = uniqueContributionRepository.findById(
                    contributionConfig.get().getUniqueContribution().getUnique_contribution_id());
        }
        System.out.println("hkdjhas" + contributionConfig);
        return contributionConfig.get();
    }
}