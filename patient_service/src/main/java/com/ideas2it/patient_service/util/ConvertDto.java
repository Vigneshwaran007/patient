package com.ideas2it.patient_service.util;

import com.ideas2it.patient_service.dto.PatientDto;
import com.ideas2it.patient_service.entity.PatientEntity;

@FunctionalInterface
public interface ConvertDto {

	/**
	 * formDto which converts entity to dto.
	 * 
	 * @param entity
	 * @author Vigneshwaran N
	 */
	PatientDto formDto(PatientEntity entity);
}
