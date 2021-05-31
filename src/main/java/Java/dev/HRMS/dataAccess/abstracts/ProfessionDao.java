package Java.dev.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Java.dev.HRMS.entities.concretes.Profession;

public interface ProfessionDao extends JpaRepository<Profession, Integer>{

}
