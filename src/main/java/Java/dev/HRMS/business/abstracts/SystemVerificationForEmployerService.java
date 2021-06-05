package Java.dev.HRMS.business.abstracts;

import Java.dev.HRMS.core.utilities.results.Result;
import Java.dev.HRMS.entities.concretes.Employer;

public interface SystemVerificationForEmployerService {
	
	Result isVerificated(Employer employer);
}
