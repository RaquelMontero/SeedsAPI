package com.semillas.SemillasApi.Repository;

import com.semillas.SemillasApi.Entities.Seeds.Contribution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContributionRepository extends JpaRepository<Contribution,Long> {
}
