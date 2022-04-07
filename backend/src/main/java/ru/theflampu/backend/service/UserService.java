package ru.theflampu.backend.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.theflampu.backend.entity.Question;
import ru.theflampu.backend.entity.User;
import ru.theflampu.backend.repository.UserRepository;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow();
    }

    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setAuthorities(Collections.singleton(roleService.findByAuthority("ROLE_USER")));
        return userRepository.save(user);
    }

    public User findById(int id) {
        return userRepository.findById(id).orElseThrow();
    }

    public void addSolvedQuestion(String username, Question question) {
        User user = (User) loadUserByUsername(username);
        List<Question> solvedQuestions = user.getSolvedQuestions();
        if (!solvedQuestions.contains(question))
            solvedQuestions.add(question);
        userRepository.save(user);
    }

    public boolean containsSolvedQuestion(User user, Question question) {
        return user.getSolvedQuestions().contains(question);
    }

    public User getProfile(String username) {
        return (User) loadUserByUsername(username);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void deleteById(int userId) {
        userRepository.deleteById(userId);
    }

    public void editUser(User user) {
        userRepository.save(user);
    }
}