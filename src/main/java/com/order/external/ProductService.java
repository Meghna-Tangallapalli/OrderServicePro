package com.order.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="PRODUCT-SERVICE/product")
public interface ProductService {

	@PutMapping("/reduceQty")
	public ResponseEntity<Void> reduceQuantity(@RequestParam long productId, @RequestParam long quantity) ; 
}
