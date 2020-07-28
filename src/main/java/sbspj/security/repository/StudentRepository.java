package sbspj.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sbspj.security.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	@EntityGraph(attributePaths = "authority")
	Optional<Student> findOneWithAuthoritiesByStudnt(String studnt);

	@EntityGraph(attributePaths = "authority")
	Optional<Student> findOneWithAuthoritiesByEmailIgnoreCase(String email);
}
