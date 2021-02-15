package ru.theflampu.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.theflampu.backend.entity.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {
}
