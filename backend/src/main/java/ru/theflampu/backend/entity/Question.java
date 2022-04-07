package ru.theflampu.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.theflampu.backend.security.View;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "questions")
public class Question {
    @JsonView(View.ShortInfo.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonView(View.ShortInfo.class)
    private String title;

    @JsonView(View.ShortInfo.class)
    private String text;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;

    @JsonView(View.ProfileInfo.class)
    @Setter(AccessLevel.NONE)
    @Transient
    private int testId;

    @JsonView(View.FullIInfo.class)
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "question_id")
    private List<Option> options;

    @JsonView(View.FullIInfo.class)
    @Transient
    private boolean solved = false;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return id == question.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getTestId() {
        return test.getId();
    }
}