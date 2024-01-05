package at.cserich.schooldemo.persistence.School;

import at.cserich.schooldemo.domain.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School,Double> {
}
