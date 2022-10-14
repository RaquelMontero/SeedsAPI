package com.semillas.SemillasApi.Repository;


import com.semillas.SemillasApi.Entities.User;
import com.semillas.SemillasApi.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}
