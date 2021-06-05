package Java.dev.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Java.dev.HRMS.business.abstracts.StaffService;
import Java.dev.HRMS.core.utilities.results.DataResult;
import Java.dev.HRMS.core.utilities.results.Result;
import Java.dev.HRMS.core.utilities.results.SuccessDataResult;
import Java.dev.HRMS.core.utilities.results.SuccessResult;
import Java.dev.HRMS.dataAccess.abstracts.StaffDao;
import Java.dev.HRMS.entities.concretes.Staff;
@Service
public class StaffManager implements StaffService{

	private StaffDao staffDao;
	@Autowired
	public StaffManager(StaffDao staffDao) {
		super();
		this.staffDao = staffDao;
	}

	@Override
	public DataResult<List<Staff>> getAll() {
		return new SuccessDataResult<List<Staff>>(this.staffDao.findAll(),"Staffs Listed");
	}

	@Override
	public Result add(Staff staff) {
		this.staffDao.save(staff);
		return new SuccessResult("Staff Added");
	}



}
