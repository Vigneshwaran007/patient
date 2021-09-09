package com.ideas2it.patient_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ideas2it.patient_service.entity.UserEntity;

/**
 * UserClient is act as User end point client
 * 
 * @author Vigneshwran N
 */
@FeignClient(url = "${healthcare.management.user.uri}", name = "${healthcare.management.user.name}")
public interface UserClient {

	@GetMapping("/{name}")
	public UserEntity getRoleByName(@PathVariable String name);

}
