package sbspj.repository;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sbspj.bean.ModuleBean;

@Repository(value="moduleRepo")
@Resource(name="ModuleBean")
public interface ModuleRepository extends JpaRepository<ModuleBean, Integer> {
	
	
	List<ModuleBean>findAll();
	
	Optional<ModuleBean> findById(Integer id);
	
	/*
	 * @Query() void fussySearch();
	 */

	
}
