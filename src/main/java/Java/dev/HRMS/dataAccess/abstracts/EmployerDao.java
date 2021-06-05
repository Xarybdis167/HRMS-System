package Java.dev.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Java.dev.HRMS.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer,Integer>{

	Employer findByEmail(String email);
}
