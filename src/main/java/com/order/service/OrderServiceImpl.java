package com.order.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.entity.OrderEntity;
import com.order.external.PaymentService;
import com.order.external.ProductService;
import com.order.external.models.PaymentVo;
import com.order.repository.OrderRepository;
import com.order.vo.OrderVo;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductService productService;
	
	@Autowired
	private PaymentService paymentService;

	
	@Override
	public long placeOrder(OrderVo orderVo)  {
		
		
		//reduce the quantity in product table, call the reduceQuantity API
		productService.reduceQuantity(orderVo.getProductId(), orderVo.getQuantity());
		
		//place the order
		
		OrderEntity orderRequest = OrderEntity.builder()
			.productId(orderVo.getProductId())
			.quantity(orderVo.getQuantity())			
			.orderStatus("CREATED")
			.amount(orderVo.getAmount())
			.build();
			
		OrderEntity orderEntity = orderRepository.save(orderRequest);
		
		PaymentVo paymentVo = PaymentVo.builder()
			.amount(orderEntity.getAmount())
			.orderId(Long.valueOf(orderEntity.getOrderId()).toString())
			.paymentMode(orderVo.getPaymentMode())
			.build();
			
		
			try {
				paymentService.doPayment(paymentVo);
				orderEntity.setOrderStatus("PLACED");
				log.info("Payment Done Sucessfully With Status: {} ");
				
			} catch (Exception e) {
				orderEntity.setOrderStatus("FAILED");
				log.info("Payment Failed: {} ");
			}
		
		orderRepository.save(orderEntity);	
		
		return orderEntity.getOrderId();
	}

	@Override
	public OrderVo getById(long id) {
		Optional<OrderEntity> orderEnt = orderRepository.findById(id);
		log.info("Fetching order details by id : {} " + id);
		OrderVo orderResponse =null;
		if (orderEnt.isPresent()) {
			
			
			orderResponse = OrderVo.builder()
			.orderId(orderEnt.get().getOrderId())
			.productId(orderEnt.get().getProductId())
			.quantity(orderEnt.get().getQuantity())
			.orderStatus(orderEnt.get().getOrderStatus())
			.orderDate(orderEnt.get().getOrderDate())
			.amount(orderEnt.get().getAmount())
			.build();
			
			log.info("Fetched order details by id : {} " + id);	
		}
		return orderResponse;
	}
}
