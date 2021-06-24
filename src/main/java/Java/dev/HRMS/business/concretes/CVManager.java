package Java.dev.HRMS.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Java.dev.HRMS.business.abstracts.CVService;
import Java.dev.HRMS.core.utilities.results.DataResult;
import Java.dev.HRMS.core.utilities.results.Result;
import Java.dev.HRMS.core.utilities.results.SuccessDataResult;
import Java.dev.HRMS.core.utilities.results.SuccessResult;
import Java.dev.HRMS.dataAccess.abstracts.CVDao;
import Java.dev.HRMS.entities.concretes.CV;
@Service
public class CVManager implements CVService{

	private CVDao cvDao;
	@Autowired
	public CVManager(CVDao cvDao) {
		super();
		this.cvDao = cvDao;
	}
	@Override
	public DataResult<List<CV>> getAll() {
		
		return new SuccessDataResult<List<CV>>(cvDao.findAll(),"data listed");
	}
	@Override
	public Result add(CV cv) {
		cv.setCreationDate(LocalDate.now());
		cvDao.save(cv);
		return new SuccessResult("data added");
	}

	
}
