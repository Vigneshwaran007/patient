package com.ideas2it.patient_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.patient_service.entity.PatientDetailEntity;
import com.ideas2it.patient_service.entity.PatientEntity;
import com.ideas2it.patient_service.entity.ResultEntity;
import com.ideas2it.patient_service.service.PatientService;

/**
 * PatientController which is used for Patient end point.
 * 
 * @author Vigneshwaran N
 */
@RestController
@RequestMapping("/patient")
@RefreshScope
public class PatientController {
	@Autowired
	public PatientController(PatientService patientService) {
		super();
		this.patientService = patientService;
	}

	private final PatientService patientService;

	/**
	 * registerPatient method is used to register Patient details.
	 * 
	 * @param patientEnity
	 * @return ResultEntity
	 */
	@PostMapping("/")
	public ResultEntity registerPatient(@RequestBody PatientEntity patientEntity) {
		return patientService.save(patientEntity);
	}

	/**
	 * getById method is used to get Patient detail by ID.
	 * 
	 * @param userId
	 * @return PatientDetailEntity
	 */
	@GetMapping("/{userId}")
	public PatientDetailEntity getById(@PathVariable String userId) {
		return patientService.getById(userId);
	}

	/**
	 * updateVistDate method is used to update visit date.
	 * 
	 * @param patientEnity
	 * @return PatientEntity
	 */
	@PutMapping("/updateVisitDate")
	public PatientEntity updateVistDate(@RequestBody PatientDetailEntity patientDetailEnity) {
		return patientService.updateVistDate(patientDetailEnity);
	}

	/**
	 * deleteById method is used to delete patent by ID.
	 * 
	 * @param patientId
	 * @return ResultEntity
	 */
	@DeleteMapping("/{patientId}")
	public ResultEntity deleteById(@PathVariable String patientId) {
		return patientService.deleteById(patientId);

	}
}
