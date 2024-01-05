package at.cserich.schooldemo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.domain.AbstractPersistable;


@Getter
@Setter
@NoArgsConstructor

@Slf4j
@Entity
@Table(name= "subject")
public class Subject extends AbstractEntity {

    @NotNull
    @NotBlank(message = "SubjectName cannot be Empty or Blank")
    @Column(unique = true)
    private String subjectName;


    @Builder
    public Subject(@NotNull String token,@NotNull @NotBlank String subjectName) {
        super(token);
        this.subjectName=subjectName;
    }
}
