package sbspj.security.rest;

import java.util.ArrayList;
//import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import sbspj.bean.VocabBean;
import sbspj.security.model.Authorities;
import sbspj.security.model.User;
import sbspj.security.rest.dto.UserDto;
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
	
	@PostMapping(value="/register",consumes ="application/json;charset=UTF-8")
	@ResponseBody
	public JSON registerUser(@Valid @RequestBody UserDto userDto) {
		/* 
		 * 
		  * 直接从service层判断id和uid 是否存在 应该不需要checkedreputation
		 * 
		 * 4000810651-1
		 * 
		 * */
		UtilResult utilResult=new UtilResult();
		if(userService.checkReputationByid(userDto.getId())==true) {
			utilResult=new UtilResult(201,"id already exists");
		}
		else if(userService.checkReputationByUid(userDto.getUid())==true) {
			utilResult=new UtilResult(203,"uid already exists");
		}else if(userService.checkReputationByid(userDto.getId())!=true &&
				userService.checkReputationByUid(userDto.getUid())!=true){
		User user=User.builder().id(userDto.getId())
								.uid(userDto.getUid())
								.upwd(userDto.getUpwd())
								.name(userDto.getName())
								.email(userDto.getEmail())
								.address(userDto.getAddress())
								.phone(userDto.getPhone())
								.activated(Boolean.parseBoolean(userDto.getActivated()))
								.authority(authorService.getOne(userDto.getAuthorities()))
							    .build();
		utilResult=new UtilResult(200,userService.add(user));
		}
		JSON jsonObject=(JSON)JSON.toJSON(utilResult);
		return jsonObject;

	}
	@GetMapping("/vocab")
	public List<String> userVocabList(){
		//Optional<VocabBean>
//		VocabBean vocab = new VocabBean();
//		vocab.setId(1);
//		vocab.setContext("abandon");
//		vocab.setCollect(true);
//		vocab.setLike(false);
//		String usr="pandapanda";
//		 String s=userService.vocabSet(vocab, usr);
		//传入用户名
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
	
	//@PreAuthorize("hasAnyRole('USER')")
	@GetMapping("/getoptions")
	@ResponseBody
	public JSON result() {
		List<Authorities> selectiveObject= authorService.getAllAuthorities();
		UtilResult rs=new UtilResult(200,"success",selectiveObject);
		JSON jsonObject=(JSON)JSON.toJSON(rs);
		return jsonObject;
		
	}
	
	@GetMapping("/alluser")
	@ResponseBody
	public JSON alluserJson() {
		List<User> list=userService.getAllUserList();
		UtilResult rs=new UtilResult(200, "done", list);
		JSON jsonObject=(JSON)JSON.toJSON(rs);
		return jsonObject;
		
	}
	/*
	 * @GetMapping("/getoptiontest")
	 * 
	 * @ResponseBody public List<Authorities> selectiveObject(){ return
	 * authorService.getAllAuthorities(); }
	 */
}
