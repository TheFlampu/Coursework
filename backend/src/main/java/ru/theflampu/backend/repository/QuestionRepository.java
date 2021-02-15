package ru.theflampu.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.theflampu.backend.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
