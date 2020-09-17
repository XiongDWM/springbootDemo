package sbspj.resource;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sbspj.bean.DailyReportBean;
import sbspj.repository.DailyReportRepository;


@Service(value="dailyReportService")
@Transactional
@Resource(name="dailyRepo")
public class DailyReportService {
	@Autowired
	private DailyReportRepository dailyRepo;

	
	public List<DailyReportBean> getList() {
		return dailyRepo.findAll();
	}
	public Object writeby(Integer id) {
		
		return dailyRepo.findOneWithAuthorById(id);
		
	}
}
