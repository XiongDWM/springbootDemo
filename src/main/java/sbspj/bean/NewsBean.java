package sbspj.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 * @author xiong
 *
 * 2020年6月28日-上午12:17:09
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="news_info")
public class NewsBean {
	
	@JsonIgnore
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="nid")
	@NotNull
	private String nid;
	
	@Column(name="nctnt")
	@NotNull
	private String nctnt;
	
	@Column(name="nusage")
	@NotNull
	private Integer nusage;
	
	@Column(name="nhref")
	@NotNull
	private String nhref;
	
	@Column(name="npic")
	@NotNull
	private String npic;
	
}
