package com.order.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.order.external.models.PaymentVo;

@FeignClient(name = "PAYMENT-SERVICE/payment")
public interface PaymentService {

	@PostMapping("/doPayment")
	public ResponseEntity<PaymentVo> doPayment(@RequestBody PaymentVo paymentVo);
}
