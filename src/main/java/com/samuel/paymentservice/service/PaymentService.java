package com.samuel.paymentservice.service;

import com.samuel.paymentservice.model.Payment;

public interface PaymentService {
	void sendPayment(Payment payment);
}
