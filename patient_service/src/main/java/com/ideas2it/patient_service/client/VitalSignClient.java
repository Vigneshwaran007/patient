package com.ideas2it.patient_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ideas2it.patient_service.entity.ResultEntity;
import com.ideas2it.patient_service.entity.VitalSignEntity;

/**
 * VitalSignClient is act as Vital Sign end point client
 * 
 * @author Vigneshwaran N
 */
@FeignClient(url = "${healthcare.management.vitalsign.uri}", name = "${healthcare.management.vitalsign.name}")
public interface VitalSignClient {

	@GetMapping("/getVitalSign/{patientId}/{lastVisitDate}")
	public VitalSignEntity getVitalSignById(@PathVariable String patientId, @PathVariable String lastVisitDate);

	@PostMapping("/")
	public ResultEntity register(@RequestBody VitalSignEntity vitalSignEntity);

	@DeleteMapping("/{patientId}")
	public ResultEntity deleteById(@PathVariable String patientId);
}
