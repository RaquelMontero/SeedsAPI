package com.semillas.SemillasApi.Repository;

import com.semillas.SemillasApi.Entities.Seeds.UniqueContribution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniqueContributionRepository extends JpaRepository<UniqueContribution,Long> {
}
