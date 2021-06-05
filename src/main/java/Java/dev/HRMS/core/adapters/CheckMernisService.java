package Java.dev.HRMS.core.adapters;

import Java.dev.HRMS.core.utilities.results.Result;
import Java.dev.HRMS.entities.concretes.Employee;

public interface CheckMernisService {

	Result checkIfRealPerson(Employee employee);
}
