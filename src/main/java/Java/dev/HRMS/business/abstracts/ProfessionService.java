package Java.dev.HRMS.business.abstracts;

import java.util.List;

import Java.dev.HRMS.entities.concretes.Profession;

public interface ProfessionService {

	List<Profession> getAll();
}
