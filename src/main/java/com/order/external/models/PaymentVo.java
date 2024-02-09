package com.order.external.models;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PaymentVo {

	private long id;
	private String orderId;
	private PaymentMode paymentMode;
	private long referenceNumber;
	private LocalDateTime paymentDate;
	private PaymentStatus paymentStatus;
	private long amount;
}
