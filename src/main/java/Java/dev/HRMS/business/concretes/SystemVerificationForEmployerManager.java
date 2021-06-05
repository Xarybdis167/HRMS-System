package Java.dev.HRMS.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Java.dev.HRMS.business.abstracts.SystemVerificationForEmployerService;
import Java.dev.HRMS.core.utilities.results.ErrorResult;
import Java.dev.HRMS.core.utilities.results.Result;
import Java.dev.HRMS.core.utilities.results.SuccessResult;
import Java.dev.HRMS.dataAccess.abstracts.SystemVerificationForEmployerDao;
import Java.dev.HRMS.entities.concretes.Employer;
@Service
public class SystemVerificationForEmployerManager implements SystemVerificationForEmployerService{

	private SystemVerificationForEmployerDao systemVerificationForEmployerDao;
	@Autowired
	public SystemVerificationForEmployerManager(SystemVerificationForEmployerDao systemVerificationForEmployerDao) {
		super();
		this.systemVerificationForEmployerDao = systemVerificationForEmployerDao;
	}

	@Override
	public Result isVerificated(Employer employer) {
		if(systemVerificationForEmployerDao.findByEmail(employer.getEmail()) != null) {
			return new SuccessResult();
		}
		return new ErrorResult("Personnel verification required");
	}
	

}
