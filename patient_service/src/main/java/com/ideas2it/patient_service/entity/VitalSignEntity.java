package com.ideas2it.patient_service.entity;

import java.sql.Date;
import java.util.UUID;

/**
 * VitalSignEntity which represent result for the vitalSign data.
 * 
 * @author Vigneshwaran N
 */
public class VitalSignEntity {
	private UUID patientId;
	private Integer temperatute;
	private Integer bloodPressure;
	private Integer sugerLevel;
	private String visitReason;
	private Date lastVisitDate;

	public UUID getPatientId() {
		return patientId;
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

	public Date getLastVisitDate() {
		return lastVisitDate;
	}

	public VitalSignEntity() {

	}

	private VitalSignEntity(VitalSignEntityBuilder builder) {
		this.patientId = builder.patientId;
		this.temperatute = builder.temperatute;
		this.bloodPressure = builder.bloodPressure;
		this.sugerLevel = builder.sugerLevel;
		this.visitReason = builder.visitReason;
		this.lastVisitDate = builder.lastVisitDate;
	}

	public static class VitalSignEntityBuilder {
		private UUID patientId;
		private Integer temperatute;
		private Integer bloodPressure;
		private Integer sugerLevel;
		private String visitReason;
		private Date lastVisitDate;

		public VitalSignEntityBuilder patientId(UUID patientId) {
			this.patientId = patientId;
			return this;
		}

		public VitalSignEntityBuilder temperatute(int temperatute) {
			this.temperatute = temperatute;
			return this;
		}

		public VitalSignEntityBuilder bloodPressure(int bloodPressure) {
			this.bloodPressure = bloodPressure;
			return this;
		}

		public VitalSignEntityBuilder sugerLevel(int sugerLevel) {
			this.sugerLevel = sugerLevel;
			return this;
		}

		public VitalSignEntityBuilder visitReason(String visitReason) {
			this.visitReason = visitReason;
			return this;
		}

		public VitalSignEntityBuilder lastVisitDate(Date lastVisitDate) {
			this.lastVisitDate = lastVisitDate;
			return this;
		}

		public VitalSignEntity build() {
			VitalSignEntity entity = new VitalSignEntity(this);
			return entity;
		}

	}
}
