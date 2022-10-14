package com.semillas.SemillasApi.Repository;


import com.semillas.SemillasApi.DTO.Format.ComboSeed;
import com.semillas.SemillasApi.Entities.Seeds.Contributor;
import com.semillas.SemillasApi.Entities.SeedsTracking.TrackingAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContributorRepository extends JpaRepository<Contributor,Long> {
    @Query(value="select contr.contributor_id as contributor_id, usr.name as name, usr.lastname as lastname" +
            ",usr.name as largename,usr.email as email, usr.phone as phone, usr.dni as dni from contributor contr inner join seed_user usr on usr.user_id = contr.user_id" +
            " where contr.contributor_state = 1",nativeQuery = true)
    List<ComboSeed> findActiveSeeds();
}
