package com.ideas2it.patient_service.entity;

/**
 * PatientStatus which represent status of patient Information.
 * 
 * @author Vigneshwaran N
 */
public class PatientStatus {
	PatientEntity patientEntity;
	String status;
	String message;

	public PatientEntity getPatientEntity() {
		return patientEntity;
	}

	public String getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public void setPatientEntity(PatientEntity patientEntity) {
		this.patientEntity = patientEntity;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public PatientStatus(PatientEntity patientEntity, String status, String message) {
		this.patientEntity = patientEntity;
		this.status = status;
		this.message = message;
	}

}
