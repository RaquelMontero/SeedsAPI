package com.semillas.SemillasApi.Service;

import com.semillas.SemillasApi.Entities.Volunter;
import com.semillas.SemillasApi.Repository.VolunterRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Inject
    VolunterRepository volunterRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Volunter volunter = this.volunterRepository.findByUsername(username);
        if (volunter==null){
            throw  new UsernameNotFoundException("Usuario no encontrado");
        }
        return volunter;
    }
}
