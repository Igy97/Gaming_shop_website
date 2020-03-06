package com.gamingshop.service;

import java.util.List;

/*import com.gamingshop.domain.Book;*/
import com.gamingshop.domain.CartItem;
import com.gamingshop.domain.Game;
import com.gamingshop.domain.Graphics_Card;
import com.gamingshop.domain.Laptop;
import com.gamingshop.domain.Motherboard;
import com.gamingshop.domain.Order;
import com.gamingshop.domain.Pc_Case;
import com.gamingshop.domain.Processor;
import com.gamingshop.domain.ShoppingCart;
import com.gamingshop.domain.User;

public interface CartItemService {
	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
	
	CartItem updateCartItem(CartItem cartItem);
	
	CartItem addLaptopToCartItem(Laptop laptop, User user, int qty); 
	
	CartItem addProcessorToCartItem(Processor processor, User user, int qty); 
	
	CartItem addGraphics_CardToCartItem(Graphics_Card graphics_card, User user, int qty); 
	
	CartItem addMotherboardToCartItem(Motherboard motherboard, User user, int qty); 
	
	CartItem addPc_CaseToCartItem(Pc_Case pc_case, User user, int qty); 
	
	CartItem addGameToCartItem(Game game, User user, int qty); 
	
	CartItem findById(Long id);
	
	void removeCartItem(CartItem cartItem);
	
	CartItem save(CartItem cartItem);
	
	List<CartItem> findByOrder(Order order);
}
