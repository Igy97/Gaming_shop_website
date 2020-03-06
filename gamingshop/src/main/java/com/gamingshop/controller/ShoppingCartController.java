package com.gamingshop.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gamingshop.domain.Laptop;
import com.gamingshop.domain.Motherboard;
import com.gamingshop.domain.Pc_Case;
import com.gamingshop.domain.Processor;
import com.gamingshop.domain.CartItem;
import com.gamingshop.domain.Game;
import com.gamingshop.domain.Graphics_Card;
import com.gamingshop.domain.ShoppingCart;
import com.gamingshop.domain.User;
import com.gamingshop.service.LaptopService;
import com.gamingshop.service.MotherboarService;
import com.gamingshop.service.Pc_Case_Service;
import com.gamingshop.service.ProcessorService;
import com.gamingshop.service.CartItemService;
import com.gamingshop.service.GameService;
import com.gamingshop.service.Graphics_Card_Service;
import com.gamingshop.service.ShoppingCartService;
import com.gamingshop.service.UserService;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private LaptopService laptopService;
	
	@Autowired
	private ProcessorService processorService;
	
	@Autowired
	private Graphics_Card_Service graphics_cardService;
	
	@Autowired
	private MotherboarService motherboardService;
	
	@Autowired
	private Pc_Case_Service pc_caseService;
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@Autowired
	private GameService gameService;
	
	@RequestMapping("/cart")
	public String shoppingCart(Model model, Principal principal) {
		User user = userService.findByUsername(principal.getName());
		ShoppingCart shoppingCart = user.getShoppingCart();
		
		List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);
		
		
		/*
		 * List<Laptop> laptop_list = new ArrayList<Laptop>(); List<Processor>
		 * processor_list = new ArrayList<Processor>(); List<Motherboard>
		 * motherboard_list = new ArrayList<Motherboard>(); List<Graphics_Card>
		 * graphics_card_list = new ArrayList<Graphics_Card>(); List<Pc_Case>
		 * pc_case_list = new ArrayList<Pc_Case>();
		 * 
		 * for(int i = 0; i < cartItemList.size(); i++) {
		 * if(cartItemList.get(i).getLaptop() != null) {
		 * laptop_list.add(cartItemList.get(i).getLaptop()); continue; }
		 * if(cartItemList.get(i).getGraphics_Card() != null) {
		 * graphics_card_list.add(cartItemList.get(i).getGraphics_Card()); continue; }
		 * if(cartItemList.get(i).getProcessor() != null) {
		 * processor_list.add(cartItemList.get(i).getProcessor()); continue; }
		 * if(cartItemList.get(i).getMotherboard() != null) {
		 * motherboard_list.add(cartItemList.get(i).getMotherboard()); continue; }
		 * if(cartItemList.get(i).getPc_Case() != null) {
		 * pc_case_list.add(cartItemList.get(i).getPc_Case()); continue; } }
		 */
		
		shoppingCartService.updateShoppingCart(shoppingCart);
		
		/*
		 * model.addAttribute("laptoplist", laptop_list);
		 * model.addAttribute("processorlist", processor_list);
		 * model.addAttribute("motherboardlist", motherboard_list);
		 * model.addAttribute("graphics_cardlist", graphics_card_list);
		 * model.addAttribute("pc_caselist", pc_case_list);
		 */
		model.addAttribute("cartItemList", cartItemList);
		model.addAttribute("shoppingCart",shoppingCart);
		
		return "shoppingCart";
	}

	@RequestMapping(value = "/addItem/laptop", method = RequestMethod.POST)
	public String addItem(
			@ModelAttribute("laptop") Laptop laptop,
			@ModelAttribute("qty") String qty,
			Model model, Principal principal
			) 
		{
		User user = userService.findByUsername(principal.getName());
				
			laptop = laptopService.findOne(laptop.getId());
			
			if (Integer.parseInt(qty) > laptop.getInStockNumber()) {
				model.addAttribute("notEnoughStock", true);
				return "forward:/offers/laptop/laptopDetail?id="+laptop.getId();
			}
			
			CartItem cartItem = cartItemService.addLaptopToCartItem(laptop, user, Integer.parseInt(qty));
			model.addAttribute("addlaptopSuccess", true);
			
			return "forward:/offers/laptop/laptopDetail?id="+laptop.getId();
			
	}
	
	
	@RequestMapping(value = "/addItem/game", method = RequestMethod.POST)
	public String addItem(
			@ModelAttribute("game") Game game,
			@ModelAttribute("qty") String qty,
			Model model, Principal principal
			) 
		{
		User user = userService.findByUsername(principal.getName());
				
			game = gameService.findOne(game.getId());
					
			if (Integer.parseInt(qty) > game.getInStockNumber()) {
				model.addAttribute("notEnoughStock", true);
				return "forward:/offers/game/gameDetail?id="+game.getId();
			}
			
			CartItem cartItem = cartItemService.addGameToCartItem(game, user, Integer.parseInt(qty));
			model.addAttribute("cartSuccess", true);
			
			return "forward:/offers/game/gameDetail?id="+game.getId();
			
	}
	
	
	@RequestMapping(value = "/addItem/pc_case", method = RequestMethod.POST)
	public String addItemPcCase(
			@ModelAttribute("pc_case") Pc_Case pc_case,
			@ModelAttribute("qty") String qty,
			Model model, Principal principal
			) 
		{
		User user = userService.findByUsername(principal.getName());
				
			pc_case = pc_caseService.findOne(pc_case.getId());
			
			if (Integer.parseInt(qty) > pc_case.getInStockNumber()) {
				model.addAttribute("notEnoughStock", true);
				return "forward:/offers/pc_case/pc_caseDetail?id="+pc_case.getId();
			}
			
			CartItem cartItem = cartItemService.addPc_CaseToCartItem(pc_case, user, Integer.parseInt(qty));
			model.addAttribute("cardSuccess", true);
			
			return "forward:/offers/pc_case/pc_caseDetail?id="+pc_case.getId();
			
	}
	
	@RequestMapping(value = "/addItem/processor", method = RequestMethod.POST)
	public String addItem_procesor(
			@ModelAttribute("processor") Processor processor,
			@ModelAttribute("qty") String qty,
			Model model, Principal principal
			) 
		{
		User user = userService.findByUsername(principal.getName());
		
		processor = processorService.findOne(processor.getId());
		
		if (Integer.parseInt(qty) > processor.getInStockNumber()) {
			model.addAttribute("notEnoughStock", true);
			return "forward:/offers/processor/processorDetail?id="+processor.getId();
		}
		
		CartItem cartItem = cartItemService.addProcessorToCartItem(processor, user, Integer.parseInt(qty));
		model.addAttribute("addprocessorSuccess", true);
		
		return "forward:/offers/processor/processorDetail?id="+processor.getId();	
	}
	
	@RequestMapping(value = "/addItem/motherboard", method = RequestMethod.POST)
	public String addItemMotherboard(
			@ModelAttribute("motherboard") Motherboard motherboard,
			@ModelAttribute("qty") String qty,
			Model model, Principal principal
			) 
		{
		User user = userService.findByUsername(principal.getName());
		
		motherboard = motherboardService.findOne(motherboard.getId());
		
		
		if (Integer.parseInt(qty) > motherboard .getInStockNumber()) {
			model.addAttribute("notEnoughStock", true);
			return "forward:/offers/motherboard/motherboardDetail?id="+motherboard .getId();
		}
		
		CartItem cartItem = cartItemService.addMotherboardToCartItem(motherboard , user, Integer.parseInt(qty));
		model.addAttribute("cardSuccess", true);
		
		return "forward:/offers/motherboard/motherboardDetail?id="+motherboard .getId();
			
	}
	
	
	
	
	@RequestMapping(value = "/addItem/graphics_card", method = RequestMethod.POST)
	public String addItem_graphics_card(
			@ModelAttribute("graphics_card") Graphics_Card graphics_card,
			@ModelAttribute("qty") String qty,
			Model model, Principal principal
			) 
		{
		User user = userService.findByUsername(principal.getName());
		
		graphics_card= graphics_cardService.findOne(graphics_card.getId());
		
		if (Integer.parseInt(qty) > graphics_card.getInStockNumber()) {
			model.addAttribute("notEnoughStock", true);
			return "forward:/offers/graphics_card/graphics_cardDetail?id="+graphics_card.getId();
		}
		
		CartItem cartItem = cartItemService.addGraphics_CardToCartItem(graphics_card, user, Integer.parseInt(qty));
		model.addAttribute("cardSuccess", true);
		
		return "forward:/offers/graphics_card/graphics_cardDetail?id="+graphics_card.getId();
		
		
	}
	
	
	
	@RequestMapping("/updateCartItem")
	public String updateShoppingCart(
			@ModelAttribute("id") Long cartItemId,
			@ModelAttribute("qty") int qty
			) {
		CartItem cartItem = cartItemService.findById(cartItemId);
		cartItem.setQty(qty);
		cartItemService.updateCartItem(cartItem);
		
		return "forward:/shoppingCart/cart";
	}
	
	@RequestMapping("/removeItem")
	public String removeItem(@RequestParam("id") Long id) {
		cartItemService.removeCartItem(cartItemService.findById(id));
		
		return "forward:/shoppingCart/cart";
	}
}
