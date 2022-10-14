package com.semillas.SemillasApi.Repository;


import com.semillas.SemillasApi.Entities.CommentRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRecordRepository extends JpaRepository<CommentRecord,Long> {

}
