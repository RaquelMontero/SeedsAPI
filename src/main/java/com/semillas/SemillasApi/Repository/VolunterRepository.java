package com.semillas.SemillasApi.Repository;


import com.semillas.SemillasApi.Entities.User;
import com.semillas.SemillasApi.Entities.Volunter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VolunterRepository extends JpaRepository<Volunter, Long> {
    //Optional<Volunter> findByPerson(User user);

}
