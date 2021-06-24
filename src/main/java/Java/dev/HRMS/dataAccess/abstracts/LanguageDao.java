package Java.dev.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Java.dev.HRMS.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language, Integer>{

}
