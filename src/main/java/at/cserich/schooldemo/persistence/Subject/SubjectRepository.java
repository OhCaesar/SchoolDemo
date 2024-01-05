package at.cserich.schooldemo.persistence.Subject;

import at.cserich.schooldemo.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Double> {
}
