package Java.dev.HRMS.business.abstracts;

import Java.dev.HRMS.core.utilities.results.Result;
import Java.dev.HRMS.entities.concretes.User;

public interface VerificationSeriviceForEmail {

	boolean isEmailVerificated(User user);
	Result verificate(User user);
}
