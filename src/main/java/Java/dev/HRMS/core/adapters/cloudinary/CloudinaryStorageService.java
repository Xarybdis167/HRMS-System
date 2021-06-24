package Java.dev.HRMS.core.adapters.cloudinary;


import org.springframework.web.multipart.MultipartFile;

import Java.dev.HRMS.core.utilities.results.DataResult;

public interface CloudinaryStorageService {

	DataResult<?> upload(MultipartFile multipartFile);
	DataResult<?> delete(String publicIdOfImages);
}
