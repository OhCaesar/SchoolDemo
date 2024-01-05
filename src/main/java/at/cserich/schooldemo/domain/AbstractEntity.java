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
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor

@MappedSuperclass
public abstract class AbstractEntity {

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

    public AbstractEntity(@NotNull(message = "Token must not be null!") String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "AbstractEntity{" +
                "id=" + id +
                ", version=" + version +
                ", token='" + token + '\'' +
                ", creationTS=" + creationTS +
                ", updateTS=" + updateTS +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity that = (AbstractEntity) o;
        return Objects.equals(token, that.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token);
    }
}
