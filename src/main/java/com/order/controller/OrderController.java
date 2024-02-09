package com.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.order.service.OrderService;
import com.order.vo.OrderVo;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/placeOrder")
	public ResponseEntity<Long> placeOrder(@RequestBody OrderVo orderVo) {
		long result = orderService.placeOrder(orderVo);
		return new ResponseEntity<Long>(result, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getById")
	public ResponseEntity<OrderVo> getById(@RequestParam long id){
		OrderVo order = orderService.getById(id);
		return new ResponseEntity<OrderVo>(order, HttpStatus.OK);
		
	}
}
