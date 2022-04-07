package ru.theflampu.backend.controller;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.theflampu.backend.entity.Role;
import ru.theflampu.backend.entity.User;
import ru.theflampu.backend.security.View;
import ru.theflampu.backend.service.RoleService;
import ru.theflampu.backend.service.UserService;

import java.util.List;

@RestController
@AllArgsConstructor
public class PanelController {
    private final UserService userService;
    private final RoleService roleService;

    @JsonView(View.FullIInfo.class)
    @GetMapping("/api/panel/users")
    public List<User> findAllUsers() {
        return userService.findAll();
    }

    @JsonView(View.FullIInfo.class)
    @GetMapping("/api/panel/roles")
    public List<Role> findAllRoles() {
        return roleService.findAll();
    }

    @DeleteMapping("/api/panel/deleteUser/{userId}")
    public void deleteUser(@PathVariable int userId) {
        userService.deleteById(userId);
    }

    @PostMapping("/api/panel/editUser")
    public void editUser(@RequestBody User user) {
        userService.editUser(user);
    }
}
