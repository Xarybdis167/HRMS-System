package Java.dev.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Java.dev.HRMS.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School, Integer>{

}
