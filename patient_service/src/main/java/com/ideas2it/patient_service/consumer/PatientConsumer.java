package com.ideas2it.patient_service.consumer;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.ideas2it.patient_service.entity.VitalSignEntity;

/**
 * PatientConsumer is used to consume queued value
 * 
 * @author Vigneshwaran N
 */
@Component
public class PatientConsumer {
	private static final Logger logger = LogManager.getLogger(PatientConsumer.class);

	/**
	 * consumeMessageFromQueue is used to consume queued value
	 * 
	 * @param entity
	 * @author Vigneshwaran N
	 */
	@RabbitListener(queues = "${healthcare.management.queue}")
	public void consumeMessageFromQueue(VitalSignEntity entity) {
		logger.log(Level.ALL, "Message received from QUEUE " + entity);

	}
}
