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
	@Size(min = 1, max = 50)
	private String id;
	@NotNull
	@Size(min = 4, max = 100)
	private String pwd;
	private Boolean memBoolean;
}
