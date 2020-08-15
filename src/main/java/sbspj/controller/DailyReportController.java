package sbspj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sbspj.bean.DailyReportBean;
import sbspj.resource.DailyReportService;
import sbspj.util.UtilResult;

//import sbspj.security.SecurityUtil;

@RestController
@RequestMapping("/dailyController")
public class DailyReportController {
	@Autowired
	private DailyReportService dailyReportService;
	
	
	@GetMapping("/findAll")
	public UtilResult findAllResult() {
		List<DailyReportBean> temp=dailyReportService.getList();
		UtilResult rs=new UtilResult(200, "成功", temp);
		return rs;
	}
	
	
	/*
	 * public static void main(String[] args) { String
	 * s=SecurityUtil.getCurrentUser().get(); System.out.println(s); }
	 */
}
