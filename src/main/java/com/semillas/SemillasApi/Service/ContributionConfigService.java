package com.semillas.SemillasApi.Service;


import com.semillas.SemillasApi.DTO.ContributionConfigDTO;
import com.semillas.SemillasApi.DTO.ContributionConstDTO;
import com.semillas.SemillasApi.DTO.ContributionDTO;
import com.semillas.SemillasApi.DTO.ContributionUniqDTO;
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
        contributionConfig.setUniqueContribution(contribution);
        contributionConfig.setIs_active(true);
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

    public ContributionConfigDTO getContributionConfigById(Long id){
        Optional<ContributionConfig> contributionConfig = contributionConfigRepository.findById(id);

        ContributionConfigDTO contributionConfigDTO = new ContributionConfigDTO(contributionConfig.get());

        if (contributionConfig.get().getContribution_key().equals(ContributionType.APORTE_CONSTANTE)){
            ContributionDTO contributionDTO = new ContributionConstDTO(contributionConfig.get().getConstantContribution());
            contributionConfigDTO.setContribution(contributionDTO);

        }
        else{
            ContributionDTO contributionDTO = new ContributionUniqDTO(contributionConfig.get().getUniqueContribution());
            contributionConfigDTO.setContribution(contributionDTO);

        }
        return contributionConfigDTO;
    }
}