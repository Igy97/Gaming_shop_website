package com.gamingshop.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamingshop.domain.BillingAddress;
/*import com.gamingshop.domain.Book;*/
import com.gamingshop.domain.CartItem;
import com.gamingshop.domain.Order;
import com.gamingshop.domain.Payment;
import com.gamingshop.domain.ShippingAddress;
import com.gamingshop.domain.ShoppingCart;
import com.gamingshop.domain.User;
import com.gamingshop.repository.OrderRepository;
import com.gamingshop.service.CartItemService;
import com.gamingshop.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CartItemService cartItemService;
	
	public synchronized Order createOrder(ShoppingCart shoppingCart,
			ShippingAddress shippingAddress,
			BillingAddress billingAddress,
			Payment payment,
			String shippingMethod,
			User user) {
		Order order = new Order();
		order.setBillingAddress(billingAddress);
		order.setOrderStatus("created");
		order.setPayment(payment);
		order.setShippingAddress(shippingAddress);
		order.setShippingMethod(shippingMethod);
		
		shippingAddress.setId(null);
		billingAddress.setId(null);
		payment.setId(null);
		
		List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);
		
		
		  for(CartItem cartItem : cartItemList) 
		  { 
			  int number_stock = 0;
			  if (cartItem.getLaptop() != null) 
			  {
				  number_stock = cartItem.getLaptop().getInStockNumber();
				  cartItem.setOrder(order); 
				  cartItem.getLaptop().setInStockNumber(number_stock - cartItem.getQty()); 		  
				  continue;
				} else if (cartItem.getGraphics_Card() != null) 
				{
					number_stock = cartItem.getGraphics_Card().getInStockNumber();
					cartItem.getGraphics_Card().setInStockNumber(number_stock - cartItem.getQty()); 
					cartItem.setOrder(order); 
					continue;
				} else if (cartItem.getMotherboard() != null) {
					number_stock = cartItem.getMotherboard().getInStockNumber();
					cartItem.getMotherboard().setInStockNumber(number_stock - cartItem.getQty()); 
					cartItem.setOrder(order); 
					continue;
				} else if (cartItem.getPc_Case() != null) {
					number_stock = cartItem.getPc_Case().getInStockNumber();
					cartItem.getPc_Case().setInStockNumber(number_stock - cartItem.getQty()); 
					cartItem.setOrder(order); 
					continue;
				} else if (cartItem.getProcessor() != null) {
					number_stock = cartItem.getProcessor().getInStockNumber();
					cartItem.getProcessor().setInStockNumber(number_stock - cartItem.getQty());
					cartItem.setOrder(order); 
					continue;
				}
				else if (cartItem.getGame() != null) {
					number_stock = cartItem.getGame().getInStockNumber();
					cartItem.getGame().setInStockNumber(number_stock - cartItem.getQty());
					cartItem.setOrder(order); 
					continue;
				}
			  
			  
			  
		  }
		 
		
		  order.setCartItemList(cartItemList);
		  order.setOrderDate(Calendar.getInstance().getTime());
		  order.setOrderTotal(shoppingCart.getGrandTotal());
		  shippingAddress.setOrder(order);
		  billingAddress.setOrder(order);
		  payment.setOrder(order);
		  order.setUser(user);
		  order = orderRepository.save(order);
		
		return order;
	}
	
	public Order findOne(Long id) {
		return orderRepository.findById(id).orElse(new Order());
	}

}
