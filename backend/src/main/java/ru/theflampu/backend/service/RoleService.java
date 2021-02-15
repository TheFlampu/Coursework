package ru.theflampu.backend.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.theflampu.backend.entity.Role;
import ru.theflampu.backend.repository.RoleRepository;

@Service
@AllArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role findByAuthority(String authority) {
        return roleRepository.findByAuthority(authority).orElseThrow();
    }
}
