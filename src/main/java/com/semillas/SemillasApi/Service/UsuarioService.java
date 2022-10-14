package com.semillas.SemillasApi.Service;


import com.semillas.SemillasApi.Entities.User;
import com.semillas.SemillasApi.Entities.Usuario;
import com.semillas.SemillasApi.Repository.UserRepository;
import com.semillas.SemillasApi.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    UserRepository usuarioRepository;

    public Optional<User> getByEmail(String email){
        return usuarioRepository.findByEmail(email);
    }

    public boolean existsEmail(String email){
        return usuarioRepository.existsByEmail(email);
    }

    public User save(User usuario){
        return usuarioRepository.save(usuario);
    }


}
