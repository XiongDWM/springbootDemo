package sbspj.repository;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sbspj.bean.VocabBean;

@Repository(value="vocabRepo")
@Resource(name="VocabBean")
 
public interface VocabRepopsitory extends JpaRepository<VocabBean, Integer> {
		List<VocabBean>findAll();
		
}
