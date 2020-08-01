package sbspj.security.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "user_info")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	@SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "uid")
	@NotNull
	private String uid;

	@Column(name = "upwd")
	@NotNull
	private String upwd;

	@Column(name = "name")
	@NotNull
	private String name;

	@Column(name = "address")
	@NotNull
	private String address;

	@Column(name = "phone")
	@NotNull
	private String phone;
	
	@Column(name="email")
	@NotNull
	private String email;

	@JsonIgnore
	@Column(name = "activated")
	@NotNull
	private boolean activated;

	@ManyToMany(cascade = CascadeType.REFRESH)
	@JoinTable(name = "user_authority", joinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "authority_name", referencedColumnName = "roles") })
	private Set<Authorities> authority = new HashSet<>();

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		User user=(User)obj;
		return id.equals(user.id);

	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
