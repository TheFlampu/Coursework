package ru.theflampu.backend.service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.theflampu.backend.entity.*;
import ru.theflampu.backend.repository.CategoryRepository;
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
    private final CategoryRepository categoryRepository;

    private final UserService userService;

    public Test findById(int id, String username) {
        Test test = testRepository.findById(id).orElseThrow();
        User user = (User) userService.loadUserByUsername(username);
        test.getQuestions().forEach(el -> {
            if (userService.containsSolvedQuestion(user, el)) {
                el.setSolved(true);
                el.getOptions().forEach(option -> option.setChecked(option.isCorrect()));
            }
        });
        return test;
    }

    public List<Test> findAll() {
        return testRepository.findAll();
    }

    public boolean solveQuestion(int idQuestion, List<Integer> options, String username) {
        Question question = questionRepository.findById(idQuestion).orElseThrow();

        List<Option> selectedOptions = optionRepository.findAllById(options).stream()
                .filter(el -> el.getQuestion() == question)
                .collect(Collectors.toList());

        if (selectedOptions.size() != options.size()) return false;

        List<Option> correctOptions = getCorrectOptions(question);

        if (selectedOptions.size() != correctOptions.size()) return false;

        if (selectedOptions.containsAll(correctOptions)) {
            userService.addSolvedQuestion(username, question);
            return true;
        }
        return false;
    }

    public List<Option> getCorrectOptions(Question question) {
        return question.getOptions()
                .stream()
                .filter(Option::isCorrect)
                .collect(Collectors.toList());
    }

    public Test createTest(Test test, String username) {
        User user = (User) userService.loadUserByUsername(username);
        test.setUser(user);
        test.setId(0);
        test.getQuestions().forEach(question -> {
            question.setId(0);
            question.getOptions().forEach(option -> option.setId(0));
        });
        return testRepository.save(test);
    }

    public Test editTest(Test test, String username) {
        Test sourTest = testRepository.findById(test.getId()).orElseThrow();

        User user = (User) userService.loadUserByUsername(username);

        if (sourTest.getUser() != user)
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);

        test.setUser(user);

        List<Question> oldQuestions = test.getQuestions()
                .stream()
                .filter(el -> el.getId() != 0)
                .collect(Collectors.toList());

        for (Question oldQuestion : oldQuestions) {
            Question soursQuestion = questionRepository.findById(oldQuestion.getId()).orElseThrow();

            if (!soursQuestion.getTest().equals(sourTest))
                throw new ResponseStatusException(HttpStatus.FORBIDDEN);

            List<Option> oldOptions = oldQuestion.getOptions().stream()
                    .filter(el -> el.getId() != 0)
                    .collect(Collectors.toList());

            for (Option oldOption : oldOptions) {
                Option soursOption = optionRepository.findById(oldOption.getId()).orElseThrow();

                if(!soursOption.getQuestion().equals(soursQuestion))
                    throw new ResponseStatusException(HttpStatus.FORBIDDEN);
            }
        }

        return testRepository.save(test);
    }

    public Test getEditTest(int id, String username) {
        Test test = testRepository.findById(id).orElseThrow();
        User user = (User) userService.loadUserByUsername(username);
        if (test.getUser() != user)
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        return test;
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public void deleteTest(int id, String username) {
        Test test = testRepository.findById(id).orElseThrow();
        User user = (User) userService.loadUserByUsername(username);

        if (test.getUser() != user)
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);

        testRepository.delete(test);
    }

    public List<Test> getCreatedTest(String username) {
        User user = (User) userService.loadUserByUsername(username);
        return testRepository.getAllByUser(user);
    }
}
