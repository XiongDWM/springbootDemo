package sbspj.repository;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sbspj.bean.VocabBean;

@Repository(value="vocabRepo")
@Resource(name="VocabBean")
 
public interface VocabRepopsitory extends JpaRepository<VocabBean, Integer> {
		List<VocabBean>findAll();
		@Modifying
		@Query(nativeQuery = true,value="update volcab_info set is_like=is_like+1 where id=:id")
		void likeThis(@Param("id") Integer id);
		
}
