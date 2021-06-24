package Java.dev.HRMS.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cv")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class CV {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="creation_date")
	private LocalDate creationDate;
	
	@Column(name="github_url")
	private String githubUrl;
	
	@Column(name="linkedin_url")
	private String linkedinUrl;
	
	@Column(name="cover_letter")
	private String coverLetter;
	
	@ManyToOne()
	@JoinColumn(name= "employees_id")
	private Employee employee;
	
	@ManyToOne()
	@JoinColumn(name="images_id")
	private Images images;
	
	@ManyToOne()
	@JoinColumn(name="job_experience_id")
	private JobExperience jobExperience;
	
	@ManyToOne()
	@JoinColumn(name="language_id")
	private Language language;
	
	@ManyToOne()
	@JoinColumn(name="known_technology_id")
	private KnownTechnology knownTechnology;
	
	@ManyToOne()
	@JoinColumn(name="school_id")
	private School school;
	
}
