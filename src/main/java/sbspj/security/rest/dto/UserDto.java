package sbspj.security.rest.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
//import lombok.experimental.Accessors;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String uid;
	private String upwd;
	private String name;
	private String address;
	private String phone;
	private String email;
	private String activated;
	private Integer authorities;
}
