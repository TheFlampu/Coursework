package ru.theflampu.backend.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.theflampu.backend.entity.Role;
import ru.theflampu.backend.repository.RoleRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role findByAuthority(String authority) {
        return roleRepository.findByAuthority(authority).orElseThrow();
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
