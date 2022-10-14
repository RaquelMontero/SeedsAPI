package com.semillas.SemillasApi.Repository;


import com.semillas.SemillasApi.Entities.Seeds.ContributionConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContributionConfigRepository extends JpaRepository<ContributionConfig,Long> {
}
