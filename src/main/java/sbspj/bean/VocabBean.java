package sbspj.bean;

import java.io.Serializable;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
//import sbspj.security.model.User;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="volcab_info")
public class VocabBean implements Serializable{

	private static final long serialVersionUID = 1L;
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	@Column(name="context")
	@NotNull
	private String context;
	@Column(name="translate")
	@NotNull
	private String translate;
	@Column(name = "isLike")
	@NotNull
	private boolean isLike;
	@Column(name = "isCollect")
	@NotNull
	private boolean isCollect;
	
//	@ManyToMany(mappedBy = "vocabulary")
//	private User users;

}
