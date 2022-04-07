package ru.theflampu.backend.controller;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.theflampu.backend.entity.Category;
import ru.theflampu.backend.entity.Test;
import ru.theflampu.backend.security.View;
import ru.theflampu.backend.service.TestService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@AllArgsConstructor
public class TestController {
    private final TestService testService;

    @JsonView(View.FullIInfo.class)
    @GetMapping("/api/getTest")
    public Test getTest(@RequestParam int id, @AuthenticationPrincipal String username) {
        return testService.findById(id, username);
    }

    @JsonView(View.ShortInfo.class)
    @GetMapping("/api/getTests")
    public List<Test> getTest() {
        return testService.findAll();
    }

    @PostMapping("/api/solve/{questionId}")
    public boolean solve(@PathVariable int questionId, @RequestBody List<Integer> options, @AuthenticationPrincipal String username) {
        return testService.solveQuestion(questionId, options, username);
    }

    @JsonView(View.FullIInfo.class)
    @PostMapping("/api/create")
    public Test create(@RequestBody Test test, @AuthenticationPrincipal String username) {
        return testService.createTest(test, username);
    }

    @JsonView(View.FullIInfo.class)
    @PostMapping("/api/edit")
    public ResponseEntity<Test> edit(@RequestBody Test test, @AuthenticationPrincipal String username) {
        try {
            return ResponseEntity.ok(testService.editTest(test, username));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @JsonView(View.EditInfo.class)
    @GetMapping("/api/edit")
    public ResponseEntity<Test> getEditTest(@RequestParam int id, @AuthenticationPrincipal String username) {
        try {
            return ResponseEntity.ok(testService.getEditTest(id, username));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @JsonView(View.EditInfo.class)
    @GetMapping("/api/categories")
    public List<Category> getCategories() {
        return testService.getCategories();
    }

    @DeleteMapping("/api/delete/{testId}")
    public void deleteTest(@PathVariable int testId, @AuthenticationPrincipal String username) {
        testService.deleteTest(testId, username);
    }

    @JsonView(View.ShortInfo.class)
    @GetMapping("/api/createdTest")
    public List<Test> getCreatedTest(@AuthenticationPrincipal String username) {
        return testService.getCreatedTest(username);
    }
}
