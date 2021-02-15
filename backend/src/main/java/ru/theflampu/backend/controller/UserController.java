package ru.theflampu.backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.theflampu.backend.entity.User;
import ru.theflampu.backend.service.UserService;

import java.util.Collection;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping(value = "/api/register", consumes = "application/json")
    public User registerNewUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @GetMapping("/api/getAuthorities")
    public Collection<? extends GrantedAuthority> getAuthorities(@AuthenticationPrincipal String username) {
        return userService.loadUserByUsername(username).getAuthorities();
    }

}
