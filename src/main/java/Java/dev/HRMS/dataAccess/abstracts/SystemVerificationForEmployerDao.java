package Java.dev.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Java.dev.HRMS.entities.concretes.SystemVerificationForEmployer;

public interface SystemVerificationForEmployerDao extends JpaRepository<SystemVerificationForEmployer, Integer>{
	SystemVerificationForEmployer findByEmail(String email);
}
