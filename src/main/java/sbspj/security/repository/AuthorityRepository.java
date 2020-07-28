package sbspj.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sbspj.security.model.Authorities;

@Repository
public interface AuthorityRepository extends JpaRepository<Authorities,String>{

}
