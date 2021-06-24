package Java.dev.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Java.dev.HRMS.entities.concretes.KnownTechnology;

public interface KnownTechnologyDao extends JpaRepository<KnownTechnology,Integer>{

}
