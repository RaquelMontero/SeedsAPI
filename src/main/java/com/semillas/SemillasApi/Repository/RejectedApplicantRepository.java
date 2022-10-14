package com.semillas.SemillasApi.Repository;


import com.semillas.SemillasApi.Entities.Seeds.DeactivatedContributor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RejectedApplicantRepository extends JpaRepository<DeactivatedContributor,Long> {
}
