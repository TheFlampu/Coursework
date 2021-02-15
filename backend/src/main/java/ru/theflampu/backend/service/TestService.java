package ru.theflampu.backend.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.theflampu.backend.entity.Option;
import ru.theflampu.backend.entity.Question;
import ru.theflampu.backend.entity.Test;
import ru.theflampu.backend.repository.OptionRepository;
import ru.theflampu.backend.repository.QuestionRepository;
import ru.theflampu.backend.repository.TestRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TestService {
    private final TestRepository testRepository;
    private final QuestionRepository questionRepository;
    private final OptionRepository optionRepository;

    public Test findById(Integer id) {
        return testRepository.findById(id).orElseThrow();
    }

    public List<Test> findAll() {
        return testRepository.findAll();
    }

    public boolean solveQuestion(int idQuestion, List<Option> options) {
        Question question = questionRepository.findById(idQuestion).orElseThrow();

        List<Option> selectedOptions = optionRepository.findAllById(options
                .stream()
                .mapToInt(Option::getId)
                .boxed()
                .collect(Collectors.toList())
        ).stream()
                .filter(el -> el.getQuestion() == question)
                .collect(Collectors.toList());

        if (selectedOptions.size() != options.size()) return false;

        List<Option> correctOptions = question.getOptions()
                .stream()
                .filter(Option::isCorrect)
                .collect(Collectors.toList());

        if (selectedOptions.size() != correctOptions.size()) return false;

        return selectedOptions.containsAll(correctOptions);
    }

}
