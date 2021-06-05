package Java.dev.HRMS.core.utilities.codeGenerator;

import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class CodeGeneratorManager implements CodeGeneratorService{

	@Override
	public String sendVerificationCode(String email) {
		UUID uuid = UUID.randomUUID();
		String code = uuid.toString();
			System.out.println(email + " Verification code has sent to your mail. Verification code: " + code);
		return code;
	}

	
	

}
