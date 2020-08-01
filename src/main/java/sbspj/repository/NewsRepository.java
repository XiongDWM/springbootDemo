package sbspj.repository;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sbspj.bean.NewsBean;

@Repository(value="newsRepo")
@Resource(name="NewsBean")

public interface NewsRepository extends JpaRepository<NewsBean, Integer> {
	

}
