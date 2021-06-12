package Java.dev.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import Java.dev.HRMS.business.abstracts.JobAdvertisementService;
import Java.dev.HRMS.core.utilities.results.DataResult;
import Java.dev.HRMS.core.utilities.results.ErrorDataResult;
import Java.dev.HRMS.core.utilities.results.Result;
import Java.dev.HRMS.core.utilities.results.SuccessDataResult;
import Java.dev.HRMS.core.utilities.results.SuccessResult;
import Java.dev.HRMS.dataAccess.abstracts.JobAdvertisementDao;
import Java.dev.HRMS.entities.concretes.JobAdvertisement;
import Java.dev.HRMS.entities.dtos.JobAdvertisementDto;
@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.findAll(), "Data Listed");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getAllByActive() {
		
		return new SuccessDataResult<List<JobAdvertisementDto>>
		(this.jobAdvertisementDao.getAllActive());
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getAllByActiveOrderByDate() {
		
		return new SuccessDataResult<List<JobAdvertisementDto>>
		(this.jobAdvertisementDao.findByAndSort(Sort.by("adsPublishDate")));
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getAllActiveByEmployer(int employerId) {
		List<JobAdvertisementDto> jobAdvertisement = this.jobAdvertisementDao.getAllActiveByEmployer(employerId);
		if (jobAdvertisement.size()==0) {
			return new ErrorDataResult<List<JobAdvertisementDto>>("employer, id="+employerId+" dosent exist");
		}
		return new SuccessDataResult<List<JobAdvertisementDto>>(jobAdvertisement);
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Data added");
	}

	@Override
	public Result passiveAdvertisement(int advertisementId) {
		JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.getById(advertisementId);
		jobAdvertisement.setActive(false);
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("this advertisiment transform passive");
	}

}
