package com.cloudruid.supermarket.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cloudruid.supermarket.entity.ClientOrder;
import com.cloudruid.supermarket.entity.Supermarket;

@Repository
public class ShopDAOImpl implements ShopDao {

	private EntityManager entityManager;
	
	@Autowired
	public ShopDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager; 
	}

	@Override
	@Transactional
	public void addProducts(ClientOrder order) {
		Session session = entityManager.unwrap(Session.class);
		
		String items = order.getItems();
		String prices = order.getPrices();
		String promotion1 = order.getPromotion1();
		String promotion2 = order.getPromotion2();
		
		
		List<String> listItems = new ArrayList<String>(Arrays.asList(items.split(",")));
		List<String> listPrices = new ArrayList<String>(Arrays.asList(prices.split(",")));
		List<String> listpromotions1 = new ArrayList<String>(Arrays.asList(promotion1.split(",")));
		List<String> listpromotions2 = new ArrayList<String>(Arrays.asList(promotion2.split(",")));
		
		for (int i = 0; i < listItems.size(); i++) {
	
			Supermarket market = new Supermarket();
			
			String currItem = listItems.get(i);
			market.setItem(currItem);
			market.setPrice(Integer.parseInt(listPrices.get(i)));
			if(listpromotions1.contains(currItem))
				market.setPromotion1(true);
			if(listpromotions2.contains(currItem))
				market.setPromotion2(true);
			
			session.saveOrUpdate(market);
		}
	}


	@Override
	@Transactional
	public String calculate(String products) {
		Session session = entityManager.unwrap(Session.class);
		
		List<Supermarket> listProducts = new ArrayList<>();
		
		String[] arrProducts = products.split(",");
		
		for (int i = 0; i < arrProducts.length; i++) {
			Query<Supermarket> querry = session.createQuery("from Supermarket where item=:product");
			querry.setParameter("product", arrProducts[i]);
			
				listProducts.add(querry.getSingleResult());	
		}
		int price = 0;
		for (Supermarket market : listProducts) {
			price += market.getPrice();
		}
		
	return price / 100.00  + " aws";
	}

}
