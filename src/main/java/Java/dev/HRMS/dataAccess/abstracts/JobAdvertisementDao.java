package Java.dev.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Java.dev.HRMS.entities.concretes.JobAdvertisement;
import Java.dev.HRMS.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{

	
	@Query("Select new Java.dev.HRMS.entities.dtos.JobAdvertisementDto"
			+ "(j.id, e.companyName, p.professionName, j.countOfPosition, j.adsPublishDate, j.applicationDeadline) "
			+ "From JobAdvertisement j Inner Join j.employer e Inner Join j.profession p Where j.isActive=true")
	List<JobAdvertisementDto> getAllActive();
	
	@Query("Select new Java.dev.HRMS.entities.dtos.JobAdvertisementDto"
			+ "(j.id, e.companyName, p.professionName, j.countOfPosition, j.adsPublishDate, j.applicationDeadline) "
			+ "From JobAdvertisement j Inner Join j.employer e Inner Join j.profession p Where j.isActive=true")
	List<JobAdvertisementDto> findByAndSort(Sort sort);
	
	@Query("Select new Java.dev.HRMS.entities.dtos.JobAdvertisementDto"
			+ "(j.id, e.companyName, p.professionName, j.countOfPosition, j.adsPublishDate, j.applicationDeadline) "
			+ "From JobAdvertisement j Inner Join j.employer e Inner Join j.profession p Where j.isActive=true and e.employerId=:employerId")
	List<JobAdvertisementDto> getAllActiveByEmployer(int employerId);
}
