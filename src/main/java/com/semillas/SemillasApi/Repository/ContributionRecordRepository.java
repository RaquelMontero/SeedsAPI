package com.semillas.SemillasApi.Repository;

import com.semillas.SemillasApi.Entities.SeedsTracking.ContributionRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContributionRecordRepository extends JpaRepository<ContributionRecord,Long> {
}
