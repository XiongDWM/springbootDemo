package sbspj.security.rest.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 * @author Xiong
 *
 * 2020-7-28
 * 
 * DTO for storing a user credentials
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginDto {
	@NotNull
	private String username;
	@NotNull
	private String password;
	private Boolean memBoolean;
}
