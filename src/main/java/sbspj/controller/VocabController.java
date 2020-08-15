package sbspj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sbspj.bean.VocabBean;
import sbspj.resource.VocabService;
import sbspj.util.UtilResult;

@RestController
@RequestMapping("/vcontent")
public class VocabController {
	@Autowired
	private VocabService vocabService;
	@GetMapping("/findAll")
	public UtilResult result()  {
		List<VocabBean> findAll = vocabService.getAllList();
		UtilResult rs=new UtilResult(200,"done",findAll);
		return rs;
	}
	@PostMapping("/add")
	@ResponseBody
	public void add(VocabBean vocab) {
		vocab = new VocabBean();
		vocab.setId(1);
		vocab.setContext("abandon");
		vocab.setCollect(true);
		vocab.setLike(false);
		vocabService.add(vocab);
	}
}
