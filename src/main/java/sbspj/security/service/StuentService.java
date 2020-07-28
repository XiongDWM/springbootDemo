package sbspj.security.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sbspj.security.SecurityUtil;
import sbspj.security.model.Student;
import sbspj.security.repository.StudentRepository;

@Service
@Transactional
public class StuentService {
	private final StudentRepository studentRepository;
	public StuentService(StudentRepository studentRepository){
		this.studentRepository=studentRepository;
	}
	
	@Transactional(readOnly = true)
	public Optional<Student> getStudentWithAuthorities(){
		//TODO after build SercurityUtil todo: SecurityUtils.getCurrentStudnt().flatMap(studentRepository::findOneWithAuthoritiesByStudnt);
		
		return SecurityUtil.getCurrentStudnt().flatMap(studentRepository::findOneWithAuthoritiesByStudnt);
		
	}
}
