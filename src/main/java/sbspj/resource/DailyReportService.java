package sbspj.resource;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sbspj.bean.DailyReportBean;
import sbspj.repository.DailyReportRepository;
import sbspj.security.repository.UserRepository;


@Service(value="dailyReportService")
@Transactional
@Resource(name="dailyRepo")
public class DailyReportService {
	@Autowired
	private DailyReportRepository dailyRepo;
	@Autowired 
	private UserRepository userRepo;
	
	public List<DailyReportBean> getList() {
		return dailyRepo.findAll();
	}
	public void writeby() {
		DailyReportBean temp=new DailyReportBean();
		int id=temp.getAuthor().getId();
		dailyRepo.findOneWithAuthorById(id);
		
	}
}
