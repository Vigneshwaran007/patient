package com.ideas2it.patient_service.entity;

import java.sql.Date;
import java.util.UUID;

/**
 * PatientEntity which represent entity for patient Information.
 * 
 * @author Vigneshwaran N
 */
public class PatientEntity {
	UUID patientId;
	String patientName;
	int age;
	String gender;
	String address;
	String emailId;
	String consultDoctor;
	Date lastVisitDate;

	public UUID getPatientId() {
		return patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public String getAddress() {
		return address;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getConsultDoctor() {
		return consultDoctor;
	}

	public Date getLastVisitDate() {
		return lastVisitDate;
	}

	public PatientEntity() {

	}

	private PatientEntity(PatientEntityBuilder builder) {
		this.patientId = builder.patientId;
		this.patientName = builder.patientName;
		this.age = builder.age;
		this.gender = builder.gender;
		this.address = builder.address;
		this.emailId = builder.emailId;
		this.consultDoctor = builder.consultDoctor;
		this.lastVisitDate = builder.lastVisitDate;
	}

	public static class PatientEntityBuilder {
		UUID patientId;
		String patientName;
		int age;
		String gender;
		String address;
		String emailId;
		String consultDoctor;
		Date lastVisitDate;

		public PatientEntityBuilder patientId(UUID patientId) {
			this.patientId = patientId;
			return this;
		}

		public PatientEntityBuilder patientName(String patientName) {
			this.patientName = patientName;
			return this;
		}

		public PatientEntityBuilder age(int age) {
			this.age = age;
			return this;
		}

		public PatientEntityBuilder gender(String gender) {
			this.gender = gender;
			return this;
		}

		public PatientEntityBuilder address(String address) {
			this.address = address;
			return this;
		}

		public PatientEntityBuilder emailId(String emailId) {
			this.emailId = emailId;
			return this;
		}

		public PatientEntityBuilder consultDoctor(String consultDoctor) {
			this.consultDoctor = consultDoctor;
			return this;
		}

		public PatientEntityBuilder lastVisitDate(Date lastVisitDate) {
			this.lastVisitDate = lastVisitDate;
			return this;
		}

		public PatientEntity build() {
			PatientEntity entity = new PatientEntity(this);
			return entity;
		}
	}

}
