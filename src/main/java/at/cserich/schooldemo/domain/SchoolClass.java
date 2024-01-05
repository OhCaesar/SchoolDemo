package at.cserich.schooldemo.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.ArrayList;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "schoolClass")
public class SchoolClass extends AbstractEntity {

    @NotNull
    @NotBlank(message = "ClassDefinition cannot be empty or blank")
    @Column(name = "classDefinition")
    private String classDefinition;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Teacher classTeacher;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Teacher substituteClassTeacher;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Student studentsRepresentative;

    @OneToMany(cascade = CascadeType.PERSIST)
    private ArrayList<Student> students;

    @Builder
    public SchoolClass(@NotNull(message = "token cannot be null") String token, @NotNull @NotBlank String classDefinition, Teacher classTeacher, Teacher substituteClassTeacher, ArrayList<Student> students ) {
        super(token);
        this.classDefinition=classDefinition;
        this.classTeacher=classTeacher;
        this.substituteClassTeacher=substituteClassTeacher;
        this.students=(students==null?new ArrayList<>():students);
    }
}
