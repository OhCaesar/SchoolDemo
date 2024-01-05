package at.cserich.schooldemo.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "test")
public class Test extends AbstractEntity{

    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Subject subject;
    @NotEmpty
    @Column(name = "testGrading")
    private int grade;
    @NotNull
    @Column(name = "testTime")
    private LocalDateTime testTime;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Teacher correctingTeacher;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Student student;

    @Builder
    public Test(@NotNull String token,@NotNull Student student, @NotNull Subject subject, int grade, LocalDateTime testTime, Teacher correctingTeacher) {
        super(token);
        this.student=student;
        this.correctingTeacher=correctingTeacher;
        this.testTime= testTime;
        this.grade=grade;
        this.subject=subject;
    }
}
