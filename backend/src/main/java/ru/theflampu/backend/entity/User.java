package ru.theflampu.backend.entity;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;
import ru.theflampu.backend.security.View;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "users")
public class User implements UserDetails {
    @JsonView(View.FullIInfo.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonView(View.ShortInfo.class)
    private String username;

    @JsonView({View.ProfileInfo.class, View.FullIInfo.class})
    private String email;

    @JsonView(View.FullIInfo.class)
    private String password;

    @JsonView(View.FullIInfo.class)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> authorities;

    @JsonView(View.ProfileInfo.class)
    @ManyToMany()
    @JoinTable(
            name = "solved_questions",
            inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private List<Question> solvedQuestions;

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
