package Java.dev.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Java.dev.HRMS.entities.concretes.Images;

public interface ImagesDao extends JpaRepository<Images,Integer>{

	
}
