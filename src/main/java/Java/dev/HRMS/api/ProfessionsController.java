package Java.dev.HRMS.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Java.dev.HRMS.business.abstracts.ProfessionService;
import Java.dev.HRMS.entities.concretes.Profession;


@RestController
@RequestMapping("/api/professions")

public class ProfessionsController {
	
	private ProfessionService professionService;
	
	@Autowired
	public ProfessionsController(ProfessionService professionService) {
		super();
		this.professionService = professionService;
	}
	@GetMapping("/getall")
	public List<Profession> getAll() {
		return professionService.getAll();
		
	}
}
