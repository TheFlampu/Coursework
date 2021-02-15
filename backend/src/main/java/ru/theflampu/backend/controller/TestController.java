package ru.theflampu.backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.theflampu.backend.entity.Option;
import ru.theflampu.backend.entity.Test;
import ru.theflampu.backend.service.TestService;

import java.util.List;

@RestController
@AllArgsConstructor
public class TestController {
    private final TestService testService;

    @GetMapping("/api/getTest")
    public Test getTest(@RequestParam int id) {
        return testService.findById(id);
    }

    @GetMapping("/api/getTests")
    public List<Test> getTest() {
        return testService.findAll();
    }

    @PostMapping("/api/solve/{questionId}")
    public ResponseEntity<HttpStatus> solve(@PathVariable int questionId, @RequestBody List<Option> options) {
        return testService.solveQuestion(questionId, options) ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
    }
}
