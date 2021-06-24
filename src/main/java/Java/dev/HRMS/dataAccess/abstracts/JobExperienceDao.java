package Java.dev.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Java.dev.HRMS.entities.concretes.JobExperience;

public interface JobExperienceDao extends JpaRepository<JobExperience, Integer>{

}
