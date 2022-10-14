package com.semillas.SemillasApi.Service;


import com.semillas.SemillasApi.Entities.Seeds.UniqueContribution;
import com.semillas.SemillasApi.Repository.ContributionRepository;
import com.semillas.SemillasApi.Repository.UniqueContributionRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class UniqueContributionService {
    @Inject
    ContributionRepository contributionRepository;
    @Inject
    UniqueContributionRepository uniqueContributionRepository;

    public UniqueContribution saveUniqueContribution(UniqueContribution uniqueContribution){
      contributionRepository.save(uniqueContribution.getContribution());
        return uniqueContributionRepository.save(uniqueContribution);
    }

    public UniqueContribution findUniqueContributionById(Long uniqueContributionId){
        UniqueContribution uniqueContribution=uniqueContributionRepository.getById(uniqueContributionId);
        return uniqueContribution;
    }
}