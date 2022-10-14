package com.semillas.SemillasApi.Repository;


import com.semillas.SemillasApi.Entities.Seeds.ProcessedContributor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessedContributorRepository extends JpaRepository<ProcessedContributor,Long> {
}
