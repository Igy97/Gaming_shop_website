
package com.gamingshop.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



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
import com.gamingshop.repository.CartItemRepository;
import com.gamingshop.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	private CartItemRepository cartItemRepository;

	// @Autowired // private BookToCartItemRepository bookToCartItemRepository;

	public List<CartItem> findByShoppingCart(ShoppingCart shoppingCart) {
		return cartItemRepository.findByShoppingCart(shoppingCart);
	}

	public CartItem updateCartItem(CartItem cartItem) {
		BigDecimal bigDecimal = null;

		if (cartItem.getLaptop() != null) {
			bigDecimal = new BigDecimal(cartItem.getLaptop().getOurPrice()).multiply(new BigDecimal(cartItem.getQty()));

		} else if (cartItem.getGraphics_Card() != null) {
			bigDecimal = new BigDecimal(cartItem.getGraphics_Card().getOurPrice())
					.multiply(new BigDecimal(cartItem.getQty()));
		} else if (cartItem.getMotherboard() != null) {
			bigDecimal = new BigDecimal(cartItem.getMotherboard().getOurPrice())
					.multiply(new BigDecimal(cartItem.getQty()));
		} else if (cartItem.getPc_Case() != null) {
			bigDecimal = new BigDecimal(cartItem.getPc_Case().getOurPrice())
					.multiply(new BigDecimal(cartItem.getQty()));
		} else if (cartItem.getProcessor() != null) {
			bigDecimal = new BigDecimal(cartItem.getProcessor().getOurPrice())
					.multiply(new BigDecimal(cartItem.getQty()));
		}
		else if (cartItem.getGame() != null) {
			bigDecimal = new BigDecimal(cartItem.getGame().getOurPrice())
					.multiply(new BigDecimal(cartItem.getQty()));
		}

		if (bigDecimal != null) {
			bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
			cartItem.setSubtotal(bigDecimal);
			cartItemRepository.save(cartItem);
		}

		return cartItem;
	}

	
	public CartItem addLaptopToCartItem(Laptop laptop, User user, int qty) {
		List<CartItem> cartItemList = findByShoppingCart(user.getShoppingCart());
		
		List<CartItem> list_of_laptop = new ArrayList<CartItem>();
		for (CartItem cartItem : list_of_laptop)
		{
			if(cartItem.getLaptop() != null)
				list_of_laptop.add(cartItem);
		}
		
			
		for (CartItem cartItem : list_of_laptop) {
			if(laptop.getId() == cartItem.getLaptop().getId()) {
				cartItem.setQty(cartItem.getQty()+qty);
				cartItem.setSubtotal(new BigDecimal(laptop.getOurPrice()).multiply(new BigDecimal(qty)));
				cartItemRepository.save(cartItem);
				return cartItem;
			}
		}
		
		CartItem cartItem = new CartItem();
		cartItem.setShoppingCart(user.getShoppingCart());
		cartItem.setLaptop(laptop);
		
		cartItem.setQty(qty);
		cartItem.setSubtotal(new BigDecimal(laptop.getOurPrice()).multiply(new BigDecimal(qty)));
		cartItem = cartItemRepository.save(cartItem);
			
		return cartItem;
	}
	
	public CartItem addProcessorToCartItem(Processor processor, User user, int qty) {
		List<CartItem> cartItemList = findByShoppingCart(user.getShoppingCart());
		
		List<CartItem> list_of_processor = new ArrayList<CartItem>();
		for (CartItem cartItem : cartItemList)
		{
			if(cartItem.getProcessor() != null)
				list_of_processor.add(cartItem);
		}
		
		
		for (CartItem cartItem : list_of_processor) {
			if(processor.getId() == cartItem.getProcessor().getId()) {
				cartItem.setQty(cartItem.getQty()+qty);
				cartItem.setSubtotal(new BigDecimal(processor.getOurPrice()).multiply(new BigDecimal(qty)));
				cartItemRepository.save(cartItem);
				return cartItem;
			}
		}
		
		CartItem cartItem = new CartItem();
		cartItem.setShoppingCart(user.getShoppingCart());
		cartItem.setProcessor(processor);
		
		cartItem.setQty(qty);
		cartItem.setSubtotal(new BigDecimal(processor.getOurPrice()).multiply(new BigDecimal(qty)));
		cartItem = cartItemRepository.save(cartItem);
			
		return cartItem;
	}
	
	public CartItem addGameToCartItem(Game game, User user, int qty) {
		List<CartItem> cartItemList = findByShoppingCart(user.getShoppingCart());
		
		List<CartItem> list_of_games = new ArrayList<CartItem>();
		for (CartItem cartItem : cartItemList)
		{
			if(cartItem.getGame() != null)
				list_of_games.add(cartItem);
		}
		
		
		for (CartItem cartItem : list_of_games) {
			if(game.getId() == cartItem.getGame().getId()) {
				cartItem.setQty(cartItem.getQty()+qty);
				cartItem.setSubtotal(new BigDecimal(game.getOurPrice()).multiply(new BigDecimal(qty)));
				cartItemRepository.save(cartItem);
				return cartItem;
			}
		}
		
		CartItem cartItem = new CartItem();
		cartItem.setShoppingCart(user.getShoppingCart());
		cartItem.setGame(game);
		
		cartItem.setQty(qty);
		cartItem.setSubtotal(new BigDecimal(game.getOurPrice()).multiply(new BigDecimal(qty)));
		cartItem = cartItemRepository.save(cartItem);
			
		return cartItem;
	}
	
	
	public CartItem addPc_CaseToCartItem(Pc_Case pc_case, User user, int qty) {
		List<CartItem> cartItemList = findByShoppingCart(user.getShoppingCart());
		
		List<CartItem> list_of_pc= new ArrayList<CartItem>();
		for (CartItem cartItem : cartItemList)
		{
			if(cartItem.getPc_Case() != null)
				list_of_pc.add(cartItem);
		}
		
		
		for (CartItem cartItem : list_of_pc) {
			if(pc_case.getId() == cartItem.getPc_Case().getId()) {
				cartItem.setQty(cartItem.getQty()+qty);
				cartItem.setSubtotal(new BigDecimal(pc_case.getOurPrice()).multiply(new BigDecimal(qty)));
				cartItemRepository.save(cartItem);
				return cartItem;
			}
		}
		
		CartItem cartItem = new CartItem();
		cartItem.setShoppingCart(user.getShoppingCart());
		cartItem.setPc_Case(pc_case);
		
		cartItem.setQty(qty);
		cartItem.setSubtotal(new BigDecimal(pc_case.getOurPrice()).multiply(new BigDecimal(qty)));
		cartItem = cartItemRepository.save(cartItem);
			
		return cartItem;
	}
	
	
	public CartItem addMotherboardToCartItem(Motherboard motherboard, User user, int qty) {
		List<CartItem> cartItemList = findByShoppingCart(user.getShoppingCart());
		
		List<CartItem> list_of_motherboard = new ArrayList<CartItem>();
		for (CartItem cartItem : cartItemList)
		{
			if(cartItem.getMotherboard() != null)
				list_of_motherboard.add(cartItem);
		}
		
		
		for (CartItem cartItem : list_of_motherboard) {
			if(motherboard.getId() == cartItem.getMotherboard().getId()) {
				cartItem.setQty(cartItem.getQty()+qty);
				cartItem.setSubtotal(new BigDecimal(motherboard.getOurPrice()).multiply(new BigDecimal(qty)));
				cartItemRepository.save(cartItem);
				return cartItem;
			}
		}
		
		CartItem cartItem = new CartItem();
		cartItem.setShoppingCart(user.getShoppingCart());
		cartItem.setMotherboard(motherboard);
		
		cartItem.setQty(qty);
		cartItem.setSubtotal(new BigDecimal(motherboard.getOurPrice()).multiply(new BigDecimal(qty)));
		cartItem = cartItemRepository.save(cartItem);
			
		return cartItem;
	}
	
	
	public CartItem addGraphics_CardToCartItem(Graphics_Card graphics_card, User user, int qty) {
		List<CartItem> cartItemList = findByShoppingCart(user.getShoppingCart());
		
		List<CartItem> list_of_graphics= new ArrayList<CartItem>();
		for (CartItem cartItem : cartItemList)
		{
			if(cartItem.getGraphics_Card() != null)
				list_of_graphics.add(cartItem);
		}
		
		
		for (CartItem cartItem : list_of_graphics) {
			if(graphics_card.getId() == cartItem.getGraphics_Card().getId()) {
				cartItem.setQty(cartItem.getQty()+qty);
				cartItem.setSubtotal(new BigDecimal(graphics_card.getOurPrice()).multiply(new BigDecimal(qty)));
				cartItemRepository.save(cartItem);
				return cartItem;
			}
		}
		
		CartItem cartItem = new CartItem();
		cartItem.setShoppingCart(user.getShoppingCart());
		cartItem.setGraphics_Card(graphics_card);
		
		cartItem.setQty(qty);
		cartItem.setSubtotal(new BigDecimal(graphics_card.getOurPrice()).multiply(new BigDecimal(qty)));
		cartItem = cartItemRepository.save(cartItem);
			
		return cartItem;
	}
	 

	public CartItem findById(Long id) {
		return cartItemRepository.findById(id).orElse(new CartItem());
	}

	public void removeCartItem(CartItem cartItem) {
		// bookToCartItemRepository.deleteByCartItem(cartItem);
		cartItemRepository.delete(cartItem);
	}

	public CartItem save(CartItem cartItem) {
		return cartItemRepository.save(cartItem);
	}

	public List<CartItem> findByOrder(Order order) {
		return cartItemRepository.findByOrder(order);
	}

}
