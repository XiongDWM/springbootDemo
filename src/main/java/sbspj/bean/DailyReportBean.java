package sbspj.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

//import org.hibernate.annotations.GeneratorType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import sbspj.security.model.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "dailyreport_info")
public class DailyReportBean {
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "whatlearnt")
	private String whatLearnt;

	@Column(name = "whatdone")
	private String whatDone;
	@Column(name="checked")
	private boolean isChecked=false;

	
	  @OneToOne(fetch = FetchType.LAZY)
	  
	  @JoinColumn(name = "author_id", referencedColumnName = "id") 
	  private User author;
	 
}
