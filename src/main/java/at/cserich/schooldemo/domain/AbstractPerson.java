package at.cserich.schooldemo.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor

@MappedSuperclass
public abstract class AbstractPerson{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private Integer version;
    @NotNull(message = "Token must not be null!")
    @NotBlank(message = "Token must not be blank!")
    @Column(unique = true)
    private String token;

    @CreationTimestamp
    private LocalDateTime creationTS;
    @UpdateTimestamp
    private LocalDateTime updateTS;

    @NotNull
    @NotBlank(message = "firstname cannot be empty or blank")
    private String firstName;
    @NotNull
    @NotBlank(message = "lastname cannot be empty or blank")
    private String lastName;
    @NotNull
    @NotBlank(message = "address cannot be null or empty")
    private Address address;
    public AbstractPerson(String token,String firstName,String lastName,Address address) {
        this.token=token;
        this.address=address;
        this.firstName=firstName;
        this.lastName=lastName;
    }
}
