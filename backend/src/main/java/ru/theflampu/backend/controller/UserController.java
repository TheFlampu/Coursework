package ru.theflampu.backend.controller;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.theflampu.backend.entity.User;
import ru.theflampu.backend.security.View;
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

    @JsonView(View.ShortInfo.class)
    @GetMapping("/api/getAuthorities")
    public Collection<? extends GrantedAuthority> getAuthorities(@AuthenticationPrincipal String username) {
        return userService.loadUserByUsername(username).getAuthorities();
    }

    @JsonView(View.ProfileInfo.class)
    @GetMapping("/api/profile")
    public User getProfile(@AuthenticationPrincipal String username) {
        return userService.getProfile(username);
    }
}
