package com.ideas2it.patient_service.dto;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * PatientDto represent patient table.
 * 
 * @author Vigneshwaran N
 *
 */
@Entity
@Table(name = "patient_tb")
public class PatientDto {
	@Id
	@Type(type = "uuid-char")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "patient_id")
	UUID patientId;
	@Column(name = "patient_name")
	String patientName;
	@Column(name = "age")
	int age;
	@Column(name = "gender")
	String gender;
	@Column(name = "address")
	String address;
	@Column(name = "email_id")
	String emailId;
	@Column(name = "consult_doctor")
	private String consultDoctor;
	@Column(name = "last_visit_date")
	Date lastVisitDate;

	public PatientDto() {

	}

	public PatientDto(UUID patientId, String patientName, int age, String gender, String address, String emailId,
			String consultDoctor, Date lastVisitDate) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.emailId = emailId;
		this.consultDoctor = consultDoctor;
		this.lastVisitDate = lastVisitDate;
	}

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

	public void setPatientId(UUID patientId) {
		this.patientId = patientId;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setConsultDoctor(String consultDoctor) {
		this.consultDoctor = consultDoctor;
	}

	public void setLastVisitDate(Date lastVisitDate) {
		this.lastVisitDate = lastVisitDate;
	}

}
