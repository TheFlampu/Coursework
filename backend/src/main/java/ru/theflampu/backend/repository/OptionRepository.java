package ru.theflampu.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ru.theflampu.backend.entity.Option;

@Service
public interface OptionRepository extends JpaRepository<Option, Integer> {
}
