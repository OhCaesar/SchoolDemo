package at.cserich.schooldemo.persistence.Student;

import at.cserich.schooldemo.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Double> {
}
