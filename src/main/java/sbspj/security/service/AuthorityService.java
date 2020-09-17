package sbspj.security.service;

import java.util.HashSet;
import java.util.List;

import java.util.Set;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sbspj.security.model.Authorities;
import sbspj.security.repository.AuthorityRepository;

@Service(value="authorService")
@Transactional
@Resource(name="authorRepo")
public class AuthorityService {
	@Autowired
	private AuthorityRepository authorRepo;
	
	public List<Authorities> getAllAuthorities(){

		return authorRepo.findAll();
	}
	public Set<Authorities> getOne(Integer id){
		Authorities authorities=authorRepo.findById(id).get();
		Set<Authorities> rs=new HashSet<Authorities>();
		rs.add(authorities);
		return rs;
		
	}
}
