package com.ideas2it.patient_service.util;

import com.ideas2it.patient_service.dto.PatientDto;
import com.ideas2it.patient_service.entity.PatientEntity;

@FunctionalInterface
public interface ConvertEntity {

	/**
	 * formEntity which converts dto to entity.
	 * 
	 * @param dto
	 * @author Vigneshwaran N
	 */
	PatientEntity formEntity(PatientDto dto);
}
