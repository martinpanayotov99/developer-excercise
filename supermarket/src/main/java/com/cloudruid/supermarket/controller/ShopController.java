package com.cloudruid.supermarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cloudruid.supermarket.dao.ShopDao;
import com.cloudruid.supermarket.entity.ClientOrder;

@RestController
public class ShopController {
	
	@Autowired
	private ShopDao dao;
	
	@PostMapping("/shop")
	public ClientOrder addShop(@RequestBody ClientOrder order) {
			
		dao.addProducts(order);
	
		return order;
	}
	
	@GetMapping("/check/{order}")
	public String getPrice(@PathVariable String order) {
		
		return dao.calculate(order);
	}
}
