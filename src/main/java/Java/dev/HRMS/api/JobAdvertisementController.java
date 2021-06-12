package Java.dev.HRMS.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Java.dev.HRMS.business.abstracts.JobAdvertisementService;
import Java.dev.HRMS.core.utilities.results.DataResult;
import Java.dev.HRMS.core.utilities.results.Result;
import Java.dev.HRMS.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobadvertisement")
public class JobAdvertisementController {

	private JobAdvertisementService jobAdvertisementService;
	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getallbyactive")
	public DataResult<?> getAllByActive() {
		return jobAdvertisementService.getAllByActive();
	}
	
	@GetMapping("/getallbyactiveorderbydate")
	public DataResult<?> getAllByActiveOrderByDate() {
		return jobAdvertisementService.getAllByActiveOrderByDate();
	}
	
	@GetMapping("/getallbyactiveandemployer")
	public DataResult<?> getAllByActiveAndEmployer(int employerId) {
		return jobAdvertisementService.getAllActiveByEmployer(employerId);
	}
	
	@PostMapping("/passiveads")
	public Result passiveAdvertisement(@RequestParam int advertisementId) {
		return jobAdvertisementService.passiveAdvertisement(advertisementId);
	}
	@PostMapping("/add")
	public Result addAdvertisement(@RequestParam JobAdvertisement jobAdvertisement) {
		return jobAdvertisementService.add(jobAdvertisement);
	}
	
}
