package Java.dev.HRMS.business.concretes;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Java.dev.HRMS.business.abstracts.EmailVerificationService;
import Java.dev.HRMS.business.abstracts.EmployeeService;
import Java.dev.HRMS.core.adapters.CheckMernisService;
import Java.dev.HRMS.core.utilities.business.BusinessRules;
import Java.dev.HRMS.core.utilities.codeGenerator.CodeGeneratorService;
import Java.dev.HRMS.core.utilities.results.DataResult;
import Java.dev.HRMS.core.utilities.results.ErrorResult;
import Java.dev.HRMS.core.utilities.results.Result;
import Java.dev.HRMS.core.utilities.results.SuccessDataResult;
import Java.dev.HRMS.core.utilities.results.SuccessResult;
import Java.dev.HRMS.dataAccess.abstracts.EmployeeDao;
import Java.dev.HRMS.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService{
	
	
	
	private EmployeeDao employeeDao;
	private CheckMernisService checkMernisService;
	private CodeGeneratorService verificationService;
	private EmailVerificationService emailVerificationService;
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao, CheckMernisService checkMernisService, CodeGeneratorService verificationService,EmailVerificationService emailVerificationService) {
		super();
		this.employeeDao = employeeDao;
		this.checkMernisService = checkMernisService;
		this.verificationService = verificationService;
		this.emailVerificationService = emailVerificationService;
		
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(),"Employees Listed");
	}

	@Override
	public Result add(Employee employee,String password) {
		 Result result = BusinessRules.run(nullControlForEmployee(employee),
				 checkMernisService.checkIfRealPerson(employee),
				emailVerificationService.isVerificated(employee.getEmail()),
				isEmployeeExist(employee),
				isPasswordValid(employee, password));
		if(result.isSuccess() == true) {
			this.employeeDao.save(employee);
			return new SuccessResult("Employee Succesfully Added");
		}
		
		return new ErrorResult(result.getMessage());
		
		
		
	}

	private Result nullControlForEmployee(Employee employee) {
		
		if(Objects.isNull(employee.getNationalIdentity()) || Objects.isNull(employee.getFirstName())
				|| Objects.isNull(employee.getLastName()) || Objects.isNull(employee.getBirthYear()) 
				|| Objects.isNull(employee.getPassword())) {
			return new ErrorResult("Every fields must filled");
		}else {
			
			return new SuccessResult("");
		}
	}
		
	private Result isEmployeeExist(Employee employee) {
		
		if(employeeDao.findByEmail(employee.getEmail()) == null && employeeDao.findByNationalIdentity(employee.getNationalIdentity()) == null) {
			return new SuccessResult();
		}
		return new ErrorResult("Email or National Identitiy already exist");
	}

	private Result isPasswordValid(Employee employee,String password) {
		
		String pass = employee.getPassword();
		if(pass.equals(password)) {
			return new SuccessResult();
		}
		return new ErrorResult("Passwords is not match");
	}
}
