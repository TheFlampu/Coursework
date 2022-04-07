package ru.theflampu.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.theflampu.backend.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
