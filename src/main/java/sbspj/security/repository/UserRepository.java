package sbspj.security.repository;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sbspj.security.model.User;

@Repository(value = "userRepo")
@Resource(name = "User")
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query(nativeQuery = true,value="SELECT* FROM USER_INFO WHERE UID=:uid")
	User findbyUid(@Param("uid")String uid);
	
	@EntityGraph(attributePaths = "authority")
	Optional<User> findOneWithAuthoritiesByUid(String uid);

	@EntityGraph(attributePaths = "authority")
	Optional<User> findOneWithAuthoritiesByEmailIgnoreCase(String email);

	@EntityGraph(attributePaths = "vocabulary")
	Optional<User> findOneWithVocabByUid(String uid);

}
