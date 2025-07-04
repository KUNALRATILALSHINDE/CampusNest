package in.kunal.main.repository;

import in.kunal.main.model.Student;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

	List<Student> findBySkillsContainingIgnoreCase(String skill);

	Optional<Student> findByEmail(String email);
}
