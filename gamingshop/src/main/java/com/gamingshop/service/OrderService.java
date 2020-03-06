package com.gamingshop.service;

import com.gamingshop.domain.BillingAddress;
import com.gamingshop.domain.Order;
import com.gamingshop.domain.Payment;
import com.gamingshop.domain.ShippingAddress;
import com.gamingshop.domain.ShoppingCart;
import com.gamingshop.domain.User;

public interface OrderService {
	Order createOrder(ShoppingCart shoppingCart,
			ShippingAddress shippingAddress,
			BillingAddress billingAddress,
			Payment payment,
			String shippingMethod,
			User user);
	
	Order findOne(Long id);
}
