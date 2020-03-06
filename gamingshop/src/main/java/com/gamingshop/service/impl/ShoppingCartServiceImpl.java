package com.gamingshop.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamingshop.domain.CartItem;
import com.gamingshop.domain.ShoppingCart;
import com.gamingshop.repository.ShoppingCartRepository;
import com.gamingshop.service.CartItemService;
import com.gamingshop.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{
	
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	
	public ShoppingCart updateShoppingCart(ShoppingCart shoppingCart) {
		BigDecimal cartTotal = new BigDecimal(0);
		
		List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);
		
		
		  for (CartItem cartItem : cartItemList) 
		  {
			  int number_stock = 0;
			  if (cartItem.getLaptop() != null) 
			  {
				  number_stock = cartItem.getLaptop().getInStockNumber();

				} else if (cartItem.getGraphics_Card() != null) 
				{
					number_stock = cartItem.getGraphics_Card().getInStockNumber();
				} else if (cartItem.getMotherboard() != null) {
					number_stock = cartItem.getMotherboard().getInStockNumber();
				} else if (cartItem.getPc_Case() != null) {
					number_stock = cartItem.getPc_Case().getInStockNumber();
				} else if (cartItem.getProcessor() != null) {
					number_stock = cartItem.getProcessor().getInStockNumber();}
				 else if (cartItem.getGame() != null) {
						number_stock = cartItem.getGame().getInStockNumber();
				}
			  
			  
			  if(number_stock > 0)
			  {
				  cartItemService.updateCartItem(cartItem); 
				  cartTotal = cartTotal.add(cartItem.getSubtotal());
			  }
			 
		  }
		 
		
		shoppingCart.setGrandTotal(cartTotal);
		
		shoppingCartRepository.save(shoppingCart);
		
		return shoppingCart;
	}
	
	public void clearShoppingCart(ShoppingCart shoppingCart) {
		List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);
		
		for (CartItem cartItem : cartItemList) {
			cartItem.setShoppingCart(null);
			cartItemService.save(cartItem);
		}
		
		shoppingCart.setGrandTotal(new BigDecimal(0));
		
		shoppingCartRepository.save(shoppingCart);
	}

}
