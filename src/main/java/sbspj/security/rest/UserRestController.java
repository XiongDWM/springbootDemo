package sbspj.security.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sbspj.security.model.User;
import sbspj.security.service.UserService;

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
	
	@GetMapping("/user")
	public ResponseEntity<User> getActualEntity(){
		return ResponseEntity.ok(userService.getStudentWithAuthorities().get());
	}
}
