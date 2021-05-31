package Java.dev.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Java.dev.HRMS.business.abstracts.ProfessionService;
import Java.dev.HRMS.dataAccess.abstracts.ProfessionDao;
import Java.dev.HRMS.entities.concretes.Profession;

@Service
public class ProfessionManager implements ProfessionService{

	private ProfessionDao professionDao;
	@Autowired
	public ProfessionManager(ProfessionDao professionDao) {
		super();
		this.professionDao = professionDao;
	}

	@Override
	public List<Profession> getAll() {
		
		return professionDao.findAll();
	}

}
