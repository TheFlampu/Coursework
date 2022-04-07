package ru.theflampu.backend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
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
@Table(name = "tests")
public class Test {
    @JsonView(View.ShortInfo.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonView(View.ShortInfo.class)
    private String title;

    @JsonView(View.ShortInfo.class)
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonView(View.ShortInfo.class)
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @JsonView(View.FullIInfo.class)
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "test_id")
    private List<Question> questions;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return id == test.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

