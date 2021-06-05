package Java.dev.HRMS.business.abstracts;



import Java.dev.HRMS.core.utilities.results.DataResult;
import Java.dev.HRMS.core.utilities.results.Result;
import Java.dev.HRMS.entities.concretes.EmailVerification;

public interface EmailVerificationService {

	DataResult<EmailVerification> getById(int id);
	Result add(EmailVerification emailVerification);
	Result isVerificated(String email);
}
