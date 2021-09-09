package com.ideas2it.patient_service.service;

import java.util.Optional;
import java.util.UUID;

import javax.sql.DataSource;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Service;

import com.ideas2it.patient_service.client.UserClient;
import com.ideas2it.patient_service.client.VitalSignClient;
import com.ideas2it.patient_service.dto.PatientDto;
import com.ideas2it.patient_service.entity.PatientDetailEntity;
import com.ideas2it.patient_service.entity.PatientEntity;
import com.ideas2it.patient_service.entity.PatientStatus;
import com.ideas2it.patient_service.entity.ResultEntity;
import com.ideas2it.patient_service.entity.UserEntity;
import com.ideas2it.patient_service.entity.VitalSignEntity;
import com.ideas2it.patient_service.repository.PatientRepository;
import com.ideas2it.patient_service.util.EntityAndDtoConversion;

/**
 * PatientService which implement PatientService.
 * 
 * @author Vigneshwaran N
 */
@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	public PatientServiceImpl(UserClient userClient, PatientRepository patientRepository, VitalSignClient vitalClient,
			RabbitTemplate template, DataSource dataSource) {
		super();
		this.userClient = userClient;
		this.patientRepository = patientRepository;
		this.vitalSignClient = vitalClient;
		this.template = template;
		this.dataSource = dataSource;

	}

	private final UserClient userClient;
	private final PatientRepository patientRepository;
	private final VitalSignClient vitalSignClient;
	private final RabbitTemplate template;
	private final DataSource dataSource;
	private static final Logger logger = LogManager.getLogger(PatientServiceImpl.class);

	@Value("${healthcare.management.queue}")
	String queue;
	@Value("${healthcare.management.exchange}")
	String exchange;
	@Value("${healthcare.management.routingqueue}")
	String routingQueue;

	@Override
	public ResultEntity save(PatientEntity patientEntity) {
		if (validateDoctor(patientEntity.getConsultDoctor())) {
			patientRepository.save(EntityAndDtoConversion.formDto(patientEntity));
			PatientStatus status = new PatientStatus(patientEntity, "PROCESS", "Your VitalSign updated successfuly");
			logger.log(Level.ALL, "exchange+++++++++++++++++++++++" + exchange);
			template.convertAndSend(exchange, routingQueue, status);
			logger.log(Level.ALL, "dataSource========================" + dataSource);
			return new ResultEntity.ResultEntityBuilder().result(true).build();
		}
		return new ResultEntity.ResultEntityBuilder().result(false).build();
	}

	/**
	 * validateDoctor method is used to validate given doctor name is valid or not.
	 * 
	 * @param doctorName
	 * @return boolean
	 */
	public boolean validateDoctor(String doctorName) {

		UserEntity userEntity = userClient.getRoleByName(doctorName);
		if (userEntity != null && userEntity.getRoleName().equalsIgnoreCase("doctor")) {
			return true;
		} else {
			logger.log(Level.ALL, "I am not a DOCTOR.............................+++++++++++++++");
			return false;
		}

	}

	@Override
	public PatientDetailEntity getById(String userId) {
		Optional<PatientDto> patientDto = patientRepository.findById(UUID.fromString(userId));
		if (patientDto.isEmpty()) {
			return null;
		}

		VitalSignEntity vitalSignEntity = vitalSignClient.getVitalSignById(patientDto.get().getPatientId().toString(),
				patientDto.get().getLastVisitDate().toString());
		PatientDetailEntity patientDetailEntity = null;
		if (vitalSignEntity != null) {
			patientDetailEntity = new PatientDetailEntity.PatientDetailEntityBuilder()
					.patientID(patientDto.get().getPatientId()).patientName(patientDto.get().getPatientName())
					.consultDoctor(patientDto.get().getConsultDoctor()).gender(patientDto.get().getGender())
					.emailId(patientDto.get().getEmailId()).address(patientDto.get().getAddress())
					.lastVisitDate(patientDto.get().getLastVisitDate()).sugerLevel(vitalSignEntity.getSugerLevel())
					.bloodPressure(vitalSignEntity.getBloodPressure()).visitReason(vitalSignEntity.getVisitReason())
					.temperatute(vitalSignEntity.getTemperatute()).build();
		} else {
			patientDetailEntity = new PatientDetailEntity.PatientDetailEntityBuilder()
					.patientID(patientDto.get().getPatientId()).patientName(patientDto.get().getPatientName())
					.consultDoctor(patientDto.get().getConsultDoctor()).gender(patientDto.get().getGender())
					.emailId(patientDto.get().getEmailId()).address(patientDto.get().getAddress())
					.lastVisitDate(patientDto.get().getLastVisitDate()).build();
		}
		return patientDetailEntity;
	}

	@Override
	public PatientEntity updateVistDate(PatientDetailEntity patientDetailEntity) {
		Optional<PatientDto> patientOpt = patientRepository.findById(patientDetailEntity.getPatientID());
		logger.log(Level.ALL, patientDetailEntity.getLastVisitDate());
		if (patientOpt.isPresent()) {
			patientOpt.get().setLastVisitDate(patientDetailEntity.getLastVisitDate());
			PatientDto patientDto = patientRepository.save(patientOpt.get());
			VitalSignEntity vitalSignEntity = new VitalSignEntity.VitalSignEntityBuilder()
					.patientId(patientDetailEntity.getPatientID()).bloodPressure(patientDetailEntity.getBloodPressure())
					.sugerLevel(patientDetailEntity.getSugerLevel()).temperatute(patientDetailEntity.getTemperatute())
					.visitReason(patientDetailEntity.getVisitReason())
					.lastVisitDate(patientDetailEntity.getLastVisitDate()).build();
			vitalSignClient.register(vitalSignEntity);
			return EntityAndDtoConversion.formEntity(patientDto);
		} else {
			return null;
		}
	}

	@Override
	public ResultEntity deleteById(String patientId) {
		Optional<PatientDto> patientOpt = patientRepository.findById(UUID.fromString(patientId));
		if (patientOpt.isPresent()) {
			patientRepository.deleteById(patientOpt.get().getPatientId());
			vitalSignClient.deleteById(patientId);
			return new ResultEntity.ResultEntityBuilder().result(true).build();
		}
		return new ResultEntity.ResultEntityBuilder().result(false).build();
	}

}
