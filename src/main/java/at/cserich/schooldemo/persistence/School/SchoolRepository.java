package at.cserich.schooldemo.persistence.School;

import at.cserich.schooldemo.domain.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SchoolRepository extends JpaRepository<School,Double> {

    Optional<School> findSchoolByToken(String token);
    Optional<School> findSchoolByName(String name);
}
