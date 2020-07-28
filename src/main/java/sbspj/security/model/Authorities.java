package sbspj.security.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "roles_info")
public class Authorities implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "roles", length = 50)
	@NotNull
	private String roles;

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Authorities authorities = (Authorities) obj;
		return roles == authorities.roles;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(roles);
	}

}
