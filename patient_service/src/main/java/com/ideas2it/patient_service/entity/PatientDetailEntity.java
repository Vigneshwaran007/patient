package com.ideas2it.patient_service.entity;

import java.sql.Date;
import java.util.UUID;

/**
 * PatientDetailEntity which represent customize entity for patient Information.
 * 
 * @author Vigneshwaran N
 */
public class PatientDetailEntity {

	private UUID patientID;
	private String patientName;
	private int age;
	private String gender;
	private String address;
	private String emailId;
	private String consultDoctor;
	private Date lastVisitDate;
	private Integer temperatute;
	private Integer bloodPressure;
	private Integer sugerLevel;
	private String visitReason;

	public UUID getPatientID() {
		return patientID;
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

	public Integer getTemperatute() {
		return temperatute;
	}

	public Integer getBloodPressure() {
		return bloodPressure;
	}

	public Integer getSugerLevel() {
		return sugerLevel;
	}

	public String getVisitReason() {
		return visitReason;
	}

	public PatientDetailEntity() {

	}

	private PatientDetailEntity(PatientDetailEntityBuilder builder) {
		this.patientID = builder.patientID;
		this.patientName = builder.patientName;
		this.age = builder.age;
		this.gender = builder.gender;
		this.address = builder.address;
		this.emailId = builder.emailId;
		this.consultDoctor = builder.consultDoctor;
		this.lastVisitDate = builder.lastVisitDate;
		this.temperatute = builder.temperatute;
		this.bloodPressure = builder.bloodPressure;
		this.sugerLevel = builder.sugerLevel;
		this.visitReason = builder.visitReason;
	}

	public static class PatientDetailEntityBuilder {
		private UUID patientID;
		private String patientName;
		private int age;
		private String gender;
		private String address;
		private String emailId;
		private String consultDoctor;
		private Date lastVisitDate;
		private Integer temperatute;
		private Integer bloodPressure;
		private Integer sugerLevel;
		private String visitReason;

		public PatientDetailEntityBuilder patientID(UUID patientID) {
			this.patientID = patientID;
			return this;
		}

		public PatientDetailEntityBuilder patientName(String patientName) {
			this.patientName = patientName;
			return this;
		}

		public PatientDetailEntityBuilder age(int age) {
			this.age = age;
			return this;
		}

		public PatientDetailEntityBuilder gender(String gender) {
			this.gender = gender;
			return this;
		}

		public PatientDetailEntityBuilder address(String address) {
			this.address = address;
			return this;
		}

		public PatientDetailEntityBuilder emailId(String emailId) {
			this.emailId = emailId;
			return this;
		}

		public PatientDetailEntityBuilder consultDoctor(String consultDoctor) {
			this.consultDoctor = consultDoctor;
			return this;
		}

		public PatientDetailEntityBuilder lastVisitDate(Date lastVisitDate) {
			this.lastVisitDate = lastVisitDate;
			return this;
		}

		public PatientDetailEntityBuilder temperatute(int temperatute) {
			this.temperatute = temperatute;
			return this;
		}

		public PatientDetailEntityBuilder bloodPressure(int bloodPressure) {
			this.bloodPressure = bloodPressure;
			return this;
		}

		public PatientDetailEntityBuilder sugerLevel(int sugerLevel) {
			this.sugerLevel = sugerLevel;
			return this;
		}

		public PatientDetailEntityBuilder visitReason(String visitReason) {
			this.visitReason = visitReason;
			return this;
		}

		public PatientDetailEntity build() {
			PatientDetailEntity entity = new PatientDetailEntity(this);
			return entity;
		}
	}
}
