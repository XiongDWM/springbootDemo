package sbspj.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import sbspj.bean.VocabBean;
import sbspj.repository.VocabRepopsitory;
import sbspj.resource.VocabService;
import sbspj.util.UtilResult;

@RestController
@RequestMapping("/vcontent")
public class VocabController {
	@Autowired
	private VocabService vocabService;
	@Autowired 
	private VocabRepopsitory vocabRepo;
	
	
	@GetMapping("/findAll")
	@ResponseBody
	@JsonIgnoreProperties(value= "users")
	public JSON result()  {
		List<VocabBean> findAll = vocabService.getAllList();
		UtilResult rs=new UtilResult(200,"done",findAll);
		JSON jsonObject=(JSON)JSON.toJSON(rs);
		return jsonObject;
	}

	// test 
	  @GetMapping("/findA")
	  
	  @ResponseBody public List<VocabBean> rsult(){
	  
	  List<VocabBean> findAll = (List<VocabBean>) vocabService.getAllList();
	  
	  return findAll;
	  
	  }
	 
	@PostMapping("/add")
	@ResponseBody
	public void add(VocabBean vocab) {
		vocab = new VocabBean();
		vocab.setContext("absorb");
		vocab.setCollect(true);
		vocab.setIsLike(0);
		vocab.setTranslate("吸收");
		vocabService.add(vocab);
	}
	
	@PostMapping("/likeThis")
	@ResponseBody
	public String likeThis(@RequestParam(name="vocabId")Integer id) {
		String vrs=vocabService.likeThis(id);
		Optional<VocabBean> vocab=vocabRepo.findById(id);
		VocabBean actualvocab=vocab.get();
		int a = actualvocab.getIsLike();
		System.out.println(a);
		return vrs;
	}
}
