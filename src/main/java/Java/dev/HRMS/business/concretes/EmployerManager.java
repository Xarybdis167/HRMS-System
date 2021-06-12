package Java.dev.HRMS.business.concretes;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Java.dev.HRMS.business.abstracts.EmailVerificationService;
import Java.dev.HRMS.business.abstracts.EmployerService;
import Java.dev.HRMS.business.abstracts.SystemVerificationForEmployerService;
import Java.dev.HRMS.core.utilities.business.BusinessRules;
import Java.dev.HRMS.core.utilities.results.DataResult;
import Java.dev.HRMS.core.utilities.results.ErrorResult;
import Java.dev.HRMS.core.utilities.results.Result;
import Java.dev.HRMS.core.utilities.results.SuccessDataResult;
import Java.dev.HRMS.core.utilities.results.SuccessResult;
import Java.dev.HRMS.dataAccess.abstracts.EmployerDao;
import Java.dev.HRMS.entities.concretes.Employer;
@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private EmailVerificationService emailVerificationService;
	private SystemVerificationForEmployerService systemVerificationForEmployerService;
	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailVerificationService emailVerificationService, SystemVerificationForEmployerService systemVerificationForEmployerService) {
		super();
		this.employerDao = employerDao;
		this.emailVerificationService = emailVerificationService;
		this.systemVerificationForEmployerService = systemVerificationForEmployerService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Employers Listed");
	}

	@Override
	public Result add(Employer employer, String password) {
		Result result = BusinessRules.run(nullControlForEmployer(employer),
				isPasswordValid(employer, password),
				emailVerificationService.isVerificated(employer.getEmail()),
				systemVerificationForEmployerService.isVerificated(employer),
				isDomainEqual(employer),
				isEmailExist(employer));
		if(result.isSuccess() == true) {
			this.employerDao.save(employer);
			return new SuccessResult("Employer Succecfully Added");
		}else {
			return new ErrorResult(result.getMessage());
		}
		
		
		
	}


	private Result nullControlForEmployer(Employer employer) {
		if(Objects.isNull(employer.getCompanyName()) || Objects.isNull(employer.getEmail())
				|| Objects.isNull(employer.getPhoneNumber()) || Objects.isNull(employer.getPassword())
				|| Objects.isNull(employer.getWebsite())) {
			return new ErrorResult("Every fields must filled");
		}else {
			
			return new SuccessResult("");
		}
	}
	
	private Result isPasswordValid(Employer employer,String password) {
		
		String pass = employer.getPassword();
		if(pass.equals(password)) {
			return new SuccessResult();
		}
		return new ErrorResult("Passwords is not match");
	}
	
	private Result isDomainEqual(Employer employer) {
		String[] emailDomain = employer.getEmail().split("@");
		if(employer.getWebsite().equals(emailDomain[1])) {
			return new SuccessResult();
		}
		return new ErrorResult("Email domain not match your website");
	}
	
	private Result isEmailExist(Employer employer) {
		if(employerDao.findByEmail(employer.getEmail()) == null) {
			return new SuccessResult();
		}
		return new ErrorResult("this email already exist");
	}

}
