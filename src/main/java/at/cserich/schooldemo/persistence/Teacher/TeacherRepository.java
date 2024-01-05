package at.cserich.schooldemo.persistence.Teacher;

import at.cserich.schooldemo.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Double> {
}
