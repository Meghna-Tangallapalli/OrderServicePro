package com.order.vo;

import java.time.LocalDateTime;

import com.order.external.models.PaymentMode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderVo {

	private long orderId;
	private long productId;
	private long quantity;
	private LocalDateTime orderDate;
	private String orderStatus;
	private long amount;
	private PaymentMode paymentMode;
}
