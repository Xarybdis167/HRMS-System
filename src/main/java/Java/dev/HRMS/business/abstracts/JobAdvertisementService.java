package Java.dev.HRMS.business.abstracts;

import java.util.List;

import Java.dev.HRMS.core.utilities.results.DataResult;
import Java.dev.HRMS.core.utilities.results.Result;
import Java.dev.HRMS.entities.concretes.JobAdvertisement;
import Java.dev.HRMS.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {

	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisementDto>> getAllByActive();
	DataResult<List<JobAdvertisementDto>> getAllByActiveOrderByDate();
	DataResult<List<JobAdvertisementDto>> getAllActiveByEmployer(int employerId);
	
	Result add(JobAdvertisement jobAdvertisement);
	Result passiveAdvertisement(int advertisementId);
}
