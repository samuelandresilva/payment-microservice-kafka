package com.samuel.paymentservice.service.impl;

import java.io.Serializable;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.samuel.paymentservice.model.Payment;
import com.samuel.paymentservice.service.PaymentService;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
	private final KafkaTemplate<String, Serializable> kafkaTemplate;
	
	@Override
	@SneakyThrows
	public void sendPayment(Payment payment) {
		log.info("Recebi o pagamento {}", payment);
		Thread.sleep(5000);
		
		log.info("Enviado pagamento...");
		kafkaTemplate.send("payment-topic", payment);
	}

}
