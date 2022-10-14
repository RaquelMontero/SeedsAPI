package com.semillas.SemillasApi.Repository;


import com.semillas.SemillasApi.Entities.ExitMessage;
import com.semillas.SemillasApi.Entities.Volunter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExitMessageRepository extends JpaRepository<ExitMessage,Long>{
    List<ExitMessage> findByVolunter(Volunter volunter);
}
