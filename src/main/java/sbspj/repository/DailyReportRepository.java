package sbspj.repository;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sbspj.bean.DailyReportBean;

@Repository(value="dailyRepo")
@Resource(name="DailyReportBean")
public interface DailyReportRepository extends JpaRepository<DailyReportBean,Integer>{
	
	@EntityGraph(attributePaths = "author")
	Optional<DailyReportBean> findOneWithAuthorById(Integer id);
	
}
