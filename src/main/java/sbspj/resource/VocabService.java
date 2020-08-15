package sbspj.resource;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sbspj.bean.VocabBean;
import sbspj.repository.VocabRepopsitory;
import sbspj.security.repository.UserRepository;
import sbspj.security.service.UserService;

@Service(value="vocabService")
@Transactional
@Resource(name = "vocabRepo")
public class VocabService {
	@Autowired
	private VocabRepopsitory vocabRepo;
	
	@Autowired
	private UserService userService;
	
	public List<VocabBean> getAllList(){
		
		return vocabRepo.findAll();
		
	}
	public VocabBean add(VocabBean vocab) {
		
		return vocabRepo.save(vocab);
		
	}
	public List<VocabBean>findVocabAlreadyCollected(){
		
		return null;
	}
}
