package at.cserich.schooldemo.persistence.SchoolClass;

import at.cserich.schooldemo.domain.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolClassRepository extends JpaRepository<SchoolClass,Double> {
}
