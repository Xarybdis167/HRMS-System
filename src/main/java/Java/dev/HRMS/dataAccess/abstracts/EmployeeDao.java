package Java.dev.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Java.dev.HRMS.entities.concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{
	Employee findByEmail(String email);
	Employee findByNationalIdentity(String nationalIdentity);

}
