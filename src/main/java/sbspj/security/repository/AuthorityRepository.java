package sbspj.security.repository;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sbspj.security.model.Authorities;

@Repository(value = "authorRepo")
@Resource(name = "Authorities")
public interface AuthorityRepository extends JpaRepository<Authorities,String>{
	
		@EntityGraph(attributePaths = "authorights")
		Optional<Authorities>findOneWithRightsById(Integer id);
}
