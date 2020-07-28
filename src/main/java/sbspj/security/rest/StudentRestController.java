package sbspj.security.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sbspj.security.model.Student;
import sbspj.security.service.StuentService;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	private final StuentService studentService;
	public StudentRestController(StuentService studentService){
		this.studentService=studentService;
	}
	@GetMapping("/studnt")
	public ResponseEntity<Student> getActualEntity(){
		return ResponseEntity.ok(studentService.getStudentWithAuthorities().get());
	}
}
