package com.order.service;

import org.springframework.stereotype.Component;

import com.order.vo.OrderVo;

@Component
public interface OrderService {

	long placeOrder(OrderVo orderVo) ;

	OrderVo getById(long id);

}
