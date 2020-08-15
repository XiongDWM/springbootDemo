package sbspj.security.rest;

import java.util.ArrayList;
//import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import sbspj.bean.VocabBean;
import sbspj.security.model.Authorities;
import sbspj.security.model.User;
import sbspj.security.service.AuthorityService;
import sbspj.security.service.UserService;
import sbspj.util.UtilResult;

@RestController
@RequestMapping("/api")
public class UserRestController {
	/*
	 * private final StuentService studentService; public
	 * StudentRestController(StuentService studentService){
	 * this.studentService=studentService; }
	 */
	@Autowired
	private UserService userService;
	@Autowired
	private AuthorityService authorService;
	
	
	@GetMapping("/user")
	public ResponseEntity<User> getActualEntity(){
		return ResponseEntity.ok(userService.getUserWithAuthorities().get());
	}
	@PostMapping("/register")
	public void registerUser() {
		User user=new User();
	}
	@GetMapping("/vocab")
	public List<String> index(){
		//Optional<VocabBean>
//		VocabBean vocab = new VocabBean();
//		vocab.setId(1);
//		vocab.setContext("abandon");
//		vocab.setCollect(true);
//		vocab.setLike(false);
//		String usr="pandapanda";
//		 String s=userService.vocabSet(vocab, usr);
		 String uid="pandapanda";
		 Optional<User> result=userService.vocabCollections(uid);
		 User userContext=result.get();
		String  name=userContext.getName();
		Set<VocabBean> collectionSet= userContext.getVocabulary();
		
		//只获得里面的单词
		Iterator<VocabBean> items=collectionSet.iterator();
		List<String> strings=new ArrayList<>();
		while(items.hasNext()) {
			VocabBean item=items.next();
			String translateString=item.getTranslate();
			String contextString=item.getContext();
			strings.add(contextString);
			strings.add(translateString);
			System.out.println(contextString);
		}
		//-----------------------------
		System.out.println(result);
		System.out.println(collectionSet);

		System.out.println(name);
		//return a;
		return strings;
	}
	
	@GetMapping("/getoptions")
	@ResponseBody
	public UtilResult result() {
		List<Authorities> selectiveObject= authorService.getAllAuthorities();
		UtilResult rs=new UtilResult(200,"success",selectiveObject);
		return rs;
		
	}
	/*
	 * @GetMapping("/getoptiontest")
	 * 
	 * @ResponseBody public List<Authorities> selectiveObject(){ return
	 * authorService.getAllAuthorities(); }
	 */
}
