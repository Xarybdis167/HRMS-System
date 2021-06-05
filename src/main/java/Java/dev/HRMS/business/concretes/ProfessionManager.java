package Java.dev.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Java.dev.HRMS.business.abstracts.ProfessionService;
import Java.dev.HRMS.core.utilities.results.DataResult;
import Java.dev.HRMS.core.utilities.results.Result;
import Java.dev.HRMS.core.utilities.results.SuccessDataResult;
import Java.dev.HRMS.core.utilities.results.SuccessResult;
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
	public DataResult<List<Profession>> getAll() {
		
		return new SuccessDataResult<List<Profession>>(this.professionDao.findAll(),"Data Listed");
	}

	@Override
	public Result add(Profession profession) {
		this.professionDao.save(profession);
		return new SuccessResult("Proffesion added");
	}


}
