package sbspj.bean;

import java.io.Serializable;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
//import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.ToString;
import sbspj.security.model.User;
//import sbspj.security.model.User;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "volcab_info")
@JsonIgnoreProperties(value= "users")
public class VocabBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@Column(name = "context")
	@NotNull
	private String context;
	@Column(name = "translate")
	@NotNull
	private String translate;
	@Column(name = "isLike")
	private Integer isLike;
	@Column(name = "isCollect")
	@NotNull
	private boolean isCollect;


	@JSONField(serialize = false)
	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, targetEntity = User.class)
	
	@JoinTable(name = "vocab_collected", joinColumns = {

			@JoinColumn(name = "vocab_id", referencedColumnName = "id") }, inverseJoinColumns = {

					@JoinColumn(name = "user_id", referencedColumnName = "id") })
	private Set<User> users = new HashSet<>();

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		VocabBean vocabBean = (VocabBean) obj;
		return id.equals(vocabBean.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "VocabBean [id=" + id + ", context=" + context + ", translate=" + translate + ", isLike=" + isLike
				+ ", isCollect=" + isCollect + "]";
	}

}
