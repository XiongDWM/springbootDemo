package sbspj.security.repository;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sbspj.security.model.User;

@Repository(value = "userRepo")
@Resource(name="User")
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@EntityGraph(attributePaths ="authority")
	Optional<User> findOneWithAuthoritiesByUid(String uid);
	
	@EntityGraph(attributePaths = "authority")
	Optional<User> findOneWithAuthoritiesByEmailIgnoreCase(String email);
	

}
