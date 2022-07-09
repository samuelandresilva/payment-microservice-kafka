package com.samuel.paymentservice.resource.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samuel.paymentservice.model.Payment;
import com.samuel.paymentservice.resource.PaymentResource;
import com.samuel.paymentservice.service.PaymentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentResourceImpl implements PaymentResource {
	private final PaymentService paymentService;
	
	@Override
	public ResponseEntity<Payment> payment(Payment payment) {
		paymentService.sendPayment(payment);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
