package at.cserich.schooldemo.persistence.Test;

import at.cserich.schooldemo.domain.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test,Double> {
}
