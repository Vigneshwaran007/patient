package com.ideas2it.patient_service.service;

import com.ideas2it.patient_service.entity.PatientDetailEntity;
import com.ideas2it.patient_service.entity.PatientEntity;
import com.ideas2it.patient_service.entity.ResultEntity;

/**
 * PatientService which involves in patient module.
 * 
 * @author Vigneshwaran N
 */
public interface PatientService {

	/**
	 * save method is used to save patient details.
	 * 
	 * @param PatientEntity
	 * @return ResultEntity
	 */
	public ResultEntity save(PatientEntity entity);

	/**
	 * getById method is used to update visit date.
	 * 
	 * @param userId
	 * @return patientDetailEnity
	 */
	public PatientDetailEntity getById(String userId);

	/**
	 * updateVistDate method is used to update visit date.
	 * 
	 * @param patientDetailEnity
	 * @return patientDetailEnity
	 */
	public PatientEntity updateVistDate(PatientDetailEntity patientDetailEnity);

	/**
	 * deleteById method is used to delete a patient.
	 * 
	 * @param patientId
	 * @return ResultEntity
	 */
	public ResultEntity deleteById(String patientId);

}
