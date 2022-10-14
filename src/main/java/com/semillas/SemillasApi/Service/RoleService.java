package com.semillas.SemillasApi.Service;

import com.semillas.SemillasApi.Entities.Role;
import com.semillas.SemillasApi.Repository.RoleRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class RoleService {
    @Inject
    RoleRepository roleRepository;

    public List<Role> getRoles() {
        return roleRepository.findAll();
    }
    public void deleteRole(long roleId) {
        roleRepository.deleteById(roleId);
    }
}
