package at.cserich.schooldemo.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "schoolOrganization")
public class School extends AbstractEntity {


    @NotNull
    @NotBlank(message = "A Schools name cannot be Empty")
    @Column(name = "schoolName")
    private String name;

    @NotNull
    @Embedded
    private Address schoolAddress;

    @OneToMany(cascade = CascadeType.PERSIST)
    @Column(name = "students")
    private ArrayList<Student> students;

    @Builder
    public School(@NotNull String token,@NotNull(message = "School must have a name!") @NotBlank String name, Address schoolAddress, ArrayList<Student> students){
        super(token);
        this.name=name;
        this.students=(students==null?new ArrayList<Student>():students);
        this.schoolAddress=schoolAddress;
    }
}
