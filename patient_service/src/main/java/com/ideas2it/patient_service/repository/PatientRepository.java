package com.ideas2it.patient_service.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ideas2it.patient_service.dto.PatientDto;

/**
 * PatientRepository repository for Patient table.
 * 
 * @author Vigneshwaran N
 */
@Repository
public interface PatientRepository extends JpaRepository<PatientDto, UUID> {

}
