package com.semillas.SemillasApi.Service;


import com.semillas.SemillasApi.Entities.Seeds.ConstantContribution;
import com.semillas.SemillasApi.Repository.ConstantContributionRepository;
import com.semillas.SemillasApi.Repository.ContributionRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class ConstantContributionService {
    @Inject
    ContributionRepository contributionRepository;
    @Inject
    ConstantContributionRepository constantContributionRepository;

    public ConstantContribution saveConstantContribution(ConstantContribution constantContribution){
        contributionRepository.save(constantContribution.getContribution());
        return constantContributionRepository.save(constantContribution);
    }

    public ConstantContribution findConstantContributionById(Long constantContributionId){
        ConstantContribution constantContribution=constantContributionRepository.getById(constantContributionId);
        return constantContribution;
    }
}