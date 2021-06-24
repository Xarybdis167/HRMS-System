package Java.dev.HRMS.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Java.dev.HRMS.business.abstracts.CVService;
import Java.dev.HRMS.core.utilities.results.DataResult;
import Java.dev.HRMS.core.utilities.results.Result;
import Java.dev.HRMS.entities.concretes.CV;

@RestController
@RequestMapping("/api/cvs")
public class CVController {

	private CVService cvService;
	@Autowired
	public CVController(CVService cvService) {
		super();
		this.cvService = cvService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<CV>> getAll() {
		return cvService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody CV cv) {
		return cvService.add(cv);
	}
}
