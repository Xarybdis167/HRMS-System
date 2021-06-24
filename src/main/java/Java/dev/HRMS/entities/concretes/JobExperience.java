package Java.dev.HRMS.entities.concretes;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="job_experiences")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobAdvertisements"})
public class JobExperience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="job_experience_id")
	private int jobExperienceId;
	
	@Column(name="job_name")
	private String jobName;
	
	@Column(name="job_description")
	private String jobDescription;
	
	@Column(name="job_position")
	private String jobPosition;
	
	@Column(name="working_yaers")
	private Date workingYears;
	
	@Column(name="yaer_of_retirement")
	private Date yearOfRetirement;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobExperience")
	private List<CV> cv;
	
}
