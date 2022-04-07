package ru.theflampu.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.theflampu.backend.security.View;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "options")
public class Option {
    @JsonView(View.ShortInfo.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonView(View.ShortInfo.class)
    private String text;

    @JsonView(View.EditInfo.class)
    private boolean correct;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @JsonView(View.ShortInfo.class)
    @Transient
    private boolean checked = false;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Option option = (Option) o;
        return id == option.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}