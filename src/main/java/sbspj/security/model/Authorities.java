package sbspj.security.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonIgnore
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "roles", length = 50)
	@NotNull
	private String roles;
	@Column(name="details")
	@NotNull
	private String details;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.REFRESH)
	@JoinTable(name = "roles_authority", joinColumns = {
			@JoinColumn(name = "author_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "rights_id", referencedColumnName = "id") })
	private Set<Rights>authorights=new HashSet<>();
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
