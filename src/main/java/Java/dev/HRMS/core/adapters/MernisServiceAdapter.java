package Java.dev.HRMS.core.adapters;

import org.springframework.stereotype.Service;

import Java.dev.HRMS.core.utilities.results.ErrorResult;
import Java.dev.HRMS.core.utilities.results.Result;
import Java.dev.HRMS.core.utilities.results.SuccessResult;
import Java.dev.HRMS.entities.concretes.Employee;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;
@Service
public class MernisServiceAdapter implements CheckMernisService{

	@Override
	public Result checkIfRealPerson(Employee employee) {
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		
		boolean serviceResult=true;
		
		try {
			
			serviceResult = client.TCKimlikNoDogrula(Long.parseLong(employee.getNationalIdentity()),
					employee.getFirstName().toUpperCase(),
					employee.getLastName().toUpperCase(),
					employee.getBirthYear());
			
		} catch (Exception e) {
			
			serviceResult=false;
		}
		
		if(serviceResult) {
			return new SuccessResult("Valid Person");
		}else {
			return new ErrorResult("Not a valid person");
		}
		
	}

}
