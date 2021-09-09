package com.ideas2it.patient_service;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ideas2it.patient_service.client.UserClient;
import com.ideas2it.patient_service.client.VitalSignClient;
import com.ideas2it.patient_service.dto.PatientDto;
import com.ideas2it.patient_service.entity.PatientDetailEntity;
import com.ideas2it.patient_service.entity.PatientEntity;
import com.ideas2it.patient_service.entity.ResultEntity;
import com.ideas2it.patient_service.entity.UserEntity;
import com.ideas2it.patient_service.entity.VitalSignEntity;
import com.ideas2it.patient_service.repository.PatientRepository;
import com.ideas2it.patient_service.service.PatientService;
import com.ideas2it.patient_service.util.EntityAndDtoConversion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.sql.Date;


@SpringBootTest
class PatientServiceApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	public PatientServiceApplicationTests(PatientService patientService) {
		this.patientService = patientService;
	}
	
	private PatientService patientService;
	
	@MockBean
	private UserClient userClient;
	
	@MockBean
	private PatientRepository patientRepository;
	
	@MockBean
	private VitalSignClient vitalSignClient; 
	
	
	@Test
	public void savePatientServiceTest() {
		UserEntity userEntity = new UserEntity.UserEntityBuilder()
				.roleId(UUID.fromString("f9364b64-5cac-466e-ba0a-7746c6b4087f")).roleName("doctor").userName("Vignesh")
				.build();

		when(userClient.getRoleByName(anyString())).thenReturn(userEntity);

		PatientEntity patientEntity = new PatientEntity.PatientEntityBuilder()
				.patientId(UUID.fromString("fcb59852-5655-4d75-ab68-e7f92b387520")).patientName("viki").age(25)
				.address("Namiyur").consultDoctor("Vignesh").emailId("viki@gmail.com").gender("male").lastVisitDate(Date.valueOf("2015-03-31")).build();

		when(patientRepository.save(any(PatientDto.class))).thenReturn(EntityAndDtoConversion.formDto(patientEntity));
		assertTrue(patientService.save(patientEntity).isResult());

	}
	
	@Test
	public void getByIdWithVitalSignServiceTest() {

		PatientEntity patientEntity = new PatientEntity.PatientEntityBuilder()
				.patientId(UUID.fromString("fcb59852-5655-4d75-ab68-e7f92b387520")).patientName("viki").age(25)
				.address("Namiyur").consultDoctor("Vignesh").emailId("viki@gmail.com").gender("male")
				.lastVisitDate(Date.valueOf("2015-03-31")).build();
		when(patientRepository.findById(any(UUID.class)))
				.thenReturn(Optional.of(EntityAndDtoConversion.formDto(patientEntity)));

		VitalSignEntity vitalSignEntity = new VitalSignEntity.VitalSignEntityBuilder()
				.patientId(UUID.fromString("fcb59852-5655-4d75-ab68-e7f92b387520")).bloodPressure(240).temperatute(120)
				.sugerLevel(100).visitReason("Genearl checkup").lastVisitDate(Date.valueOf("2015-03-31")).build();
		
		when(vitalSignClient.getVitalSignById(anyString(), anyString())).thenReturn(vitalSignEntity);
		assertEquals(240,patientService.getById("fcb59852-5655-4d75-ab68-e7f92b387520").getBloodPressure());
	}
	
	@Test
	public void getByIdWithoutVitalSignServiceTest() {

		PatientEntity patientEntity = new PatientEntity.PatientEntityBuilder()
				.patientId(UUID.fromString("fcb59852-5655-4d75-ab68-e7f92b387520")).patientName("viki").age(25)
				.address("Namiyur").consultDoctor("Vignesh").emailId("viki@gmail.com").gender("male")
				.lastVisitDate(Date.valueOf("2015-03-31")).build();
		when(patientRepository.findById(any(UUID.class)))
				.thenReturn(Optional.of(EntityAndDtoConversion.formDto(patientEntity)));
		assertEquals("viki",patientService.getById("fcb59852-5655-4d75-ab68-e7f92b387520").getPatientName());
	}
	
	@Test
	public void updateVistDateTest() {
		PatientDetailEntity detailEntity = new PatientDetailEntity.PatientDetailEntityBuilder()
				.patientID(UUID.fromString("fcb59852-5655-4d75-ab68-e7f92b387520")).patientName("viki").age(25)
				.address("Namiyur").consultDoctor("Vignesh").emailId("viki@gmail.com").gender("male")
				.lastVisitDate(Date.valueOf("2016-03-31")).temperatute(100).bloodPressure(120).sugerLevel(130)
				.visitReason("General Checkup").build();
		
		PatientEntity patientEntity = new PatientEntity.PatientEntityBuilder()
				.patientId(UUID.fromString("fcb59852-5655-4d75-ab68-e7f92b387520")).patientName("viki").age(25)
				.address("Namiyur").consultDoctor("Vignesh").emailId("viki@gmail.com").gender("male")
				.lastVisitDate(Date.valueOf("2015-03-31")).build();
		when(patientRepository.findById(any(UUID.class)))
		.thenReturn(Optional.of(EntityAndDtoConversion.formDto(patientEntity)));
		when(patientRepository.save(any(PatientDto.class))).thenReturn(EntityAndDtoConversion.formDto(patientEntity));
		assertEquals(Date.valueOf("2015-03-31"), patientService.updateVistDate(detailEntity).getLastVisitDate());
	}
	
	@Test
	public void updateVistDateFailTest() {
		PatientDetailEntity detailEntity = new PatientDetailEntity.PatientDetailEntityBuilder()
				.patientID(UUID.fromString("1ea00214-930d-4cf6-bd48-66fcab20169b")).patientName("viki").age(25)
				.address("Namiyur").consultDoctor("Vignesh").emailId("viki@gmail.com").gender("male")
				.lastVisitDate(Date.valueOf("2016-03-31")).temperatute(100).bloodPressure(120).sugerLevel(130)
				.visitReason("General Checkup").build();
		assertEquals(null, patientService.updateVistDate(detailEntity));
	}
	
	@Test
	public void deleteByIdTest() {
		PatientEntity patientEntity = new PatientEntity.PatientEntityBuilder()
				.patientId(UUID.fromString("fcb59852-5655-4d75-ab68-e7f92b387520")).patientName("viki").age(25)
				.address("Namiyur").consultDoctor("Vignesh").emailId("viki@gmail.com").gender("male")
				.lastVisitDate(Date.valueOf("2015-03-31")).build();
		when(patientRepository.findById(any(UUID.class)))
		.thenReturn(Optional.of(EntityAndDtoConversion.formDto(patientEntity)));
		ResultEntity resultEntity=new ResultEntity.ResultEntityBuilder().result(true).build();
		patientService.deleteById("fcb59852-5655-4d75-ab68-e7f92b387520");
		when(vitalSignClient.deleteById("fcb59852-5655-4d75-ab68-e7f92b387520")).thenReturn(resultEntity);
		verify(patientRepository, times(1)).deleteById(patientEntity.getPatientId());
	}
	
	@Test
	public void deleteByIdFailTest() {
		PatientEntity patientEntity = new PatientEntity.PatientEntityBuilder()
				.patientId(UUID.fromString("fcb59852-5655-4d75-ab68-e7f92b387520")).patientName("viki").age(25)
				.address("Namiyur").consultDoctor("Vignesh").emailId("viki@gmail.com").gender("male")
				.lastVisitDate(Date.valueOf("2015-03-31")).build();
		when(patientRepository.findById(any(UUID.class)))
		.thenReturn(Optional.of(EntityAndDtoConversion.formDto(patientEntity)));
		patientService.deleteById("fcb59852-5655-4d75-ab68-e7f92b387527");
		//verify(patientRepository, times(1)).deleteById(patientEntity.getPatientId());
		//verifyNoInteractions(patientRepository);
	}
}
