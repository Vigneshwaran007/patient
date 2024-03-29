package com.ideas2it.patient_service.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MessageingConfig is used to config queue
 * 
 * @author Vigneshwaran N
 */
@Configuration
public class MessageingConfig {

	@Value("${healthcare.management.queue}")
	String queue;
	@Value("${healthcare.management.exchange}")
	String exchange;
	@Value("${healthcare.management.routingqueue}")
	String routingQueue;

	@Bean
	public Queue queue() {
		return new Queue(queue);
	}

	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(exchange);
	}

	@Bean
	public Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(routingQueue);
	}

	@Bean
	public MessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}

	public AmqpTemplate template(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabitTemplate = new RabbitTemplate(connectionFactory);
		rabitTemplate.setMessageConverter(converter());
		return rabitTemplate;
	}
}
