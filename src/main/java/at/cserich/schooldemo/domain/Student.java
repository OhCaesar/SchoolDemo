package at.cserich.schooldemo.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "student")
public class Student extends AbstractPerson{


    @OneToMany(cascade = CascadeType.PERSIST)
    private ArrayList<Subject> subjects;

    @Builder
    public Student(@NotNull String token,@NotNull @NotBlank String firstName,@NotNull @NotBlank String lastName, Address address,ArrayList<Subject> subjects) {
        super(token,firstName,lastName,address);
        this.subjects = (subjects==null?new ArrayList<>():subjects);
    }
}
