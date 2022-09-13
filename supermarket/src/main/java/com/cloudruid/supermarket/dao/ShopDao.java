package com.cloudruid.supermarket.dao;

import com.cloudruid.supermarket.entity.ClientOrder;

public interface ShopDao {
	
	public void addProducts(ClientOrder order);
	public String calculate(String products);

}
