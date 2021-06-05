package Java.dev.HRMS.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Java.dev.HRMS.business.abstracts.EmailVerificationService;
import Java.dev.HRMS.core.utilities.results.DataResult;
import Java.dev.HRMS.core.utilities.results.ErrorResult;
import Java.dev.HRMS.core.utilities.results.Result;
import Java.dev.HRMS.core.utilities.results.SuccessDataResult;
import Java.dev.HRMS.core.utilities.results.SuccessResult;
import Java.dev.HRMS.dataAccess.abstracts.EmailVerificationDao;
import Java.dev.HRMS.entities.concretes.EmailVerification;
@Service
public class EmailVerificationManager implements EmailVerificationService{

	private EmailVerificationDao emailVerificationDao;
	
	
	@Autowired
	public EmailVerificationManager(EmailVerificationDao emailVerificationDao) {
		super();
		this.emailVerificationDao = emailVerificationDao;

	}

	@Override
	public DataResult<EmailVerification> getById(int id) {
		
		return new SuccessDataResult<EmailVerification>(this.emailVerificationDao.getById(id), "Email verification Listed By Id");
	}

	@Override
	public Result add(EmailVerification emailVerification) {
		this.emailVerificationDao.save(emailVerification);
		return new SuccessResult("Email Verification Added");
	}

	@Override
	public Result isVerificated(String email) {
		if(emailVerificationDao.findByEmail(email) == null) {
			return new ErrorResult("Email Verification required");
		}
		return new SuccessResult();
	}


}
