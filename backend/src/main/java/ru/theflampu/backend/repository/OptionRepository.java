package ru.theflampu.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.theflampu.backend.entity.Option;

@Repository
public interface OptionRepository extends JpaRepository<Option, Integer> {
}
