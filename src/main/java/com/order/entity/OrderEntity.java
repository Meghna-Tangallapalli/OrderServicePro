package com.order.entity;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="order_entity")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;
	
	private long productId;
	private long quantity;
	
	@CreationTimestamp
	private LocalDateTime orderDate;
	
	@UpdateTimestamp
	private LocalDateTime lastModified;
	
	private String orderStatus;
	private long amount;
}
