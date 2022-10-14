package com.semillas.SemillasApi.Repository;


import com.semillas.SemillasApi.Entities.Seeds.ConstantContribution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstantContributionRepository extends JpaRepository<ConstantContribution,Long> {
}
