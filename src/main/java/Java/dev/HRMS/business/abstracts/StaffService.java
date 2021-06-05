package Java.dev.HRMS.business.abstracts;

import java.util.List;

import Java.dev.HRMS.core.utilities.results.DataResult;
import Java.dev.HRMS.core.utilities.results.Result;
import Java.dev.HRMS.entities.concretes.Staff;

public interface StaffService {

	DataResult<List<Staff>> getAll();
	Result add(Staff staff);

}
