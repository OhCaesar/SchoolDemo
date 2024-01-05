package at.cserich.schooldemo.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor

@Entity
@Table(name = "Teacher")
public class Teacher extends AbstractPerson {

    @OneToMany(cascade = CascadeType.PERSIST)
    ArrayList<Subject> subjects;

    @Builder
    public Teacher(@NotNull String token, @NotNull @NotBlank String firstName, @NotNull @NotBlank String lastName, Address address, ArrayList<Subject> subjects) {
        super(token,firstName,lastName,address);
        this.subjects=(subjects==null?new ArrayList<>():subjects);
    }
}
