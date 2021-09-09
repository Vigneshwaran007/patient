package com.ideas2it.patient_service.util;

import com.ideas2it.patient_service.dto.PatientDto;
import com.ideas2it.patient_service.entity.PatientEntity;

/**
 * EntityAndDtoConversion which converts entity to dto and dto to entity.
 * 
 * @author Vigneshwaran N
 */
public class EntityAndDtoConversion {

	/**
	 * formDto which converts entity to dto.
	 * 
	 * @param patientEntity
	 * @author Vigneshwaran N
	 */
	public static PatientDto formDto(PatientEntity patientEntity1) {

		ConvertDto con = (patientEntity) -> {
			PatientDto patientDto = new PatientDto();
			patientDto.setPatientId(patientEntity.getPatientId());
			patientDto.setPatientName(patientEntity.getPatientName());
			patientDto.setAge(patientEntity.getAge());
			patientDto.setGender(patientEntity.getGender());
			patientDto.setAddress(patientEntity.getAddress());
			patientDto.setEmailId(patientEntity.getEmailId());
			patientDto.setConsultDoctor(patientEntity.getConsultDoctor());
			patientDto.setLastVisitDate(patientEntity.getLastVisitDate());
			return patientDto;
		};
		return con.formDto(patientEntity1);
	}

	/**
	 * formEntity which converts dto to entity.
	 * 
	 * @param PatientDto
	 * @author Vigneshwaran N
	 */
	public static PatientEntity formEntity(PatientDto dto) {

		ConvertEntity con = (patientDto) -> {
			PatientEntity patientEntity = new PatientEntity.PatientEntityBuilder().patientId(patientDto.getPatientId())
					.patientName(patientDto.getPatientName()).age(patientDto.getAge()).gender(patientDto.getGender())
					.address(patientDto.getAddress()).consultDoctor(patientDto.getConsultDoctor())
					.lastVisitDate(patientDto.getLastVisitDate()).build();
			return patientEntity;
		};
		return con.formEntity(dto);
	}

}
