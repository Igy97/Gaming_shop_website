package com.adminportal_gamingshop.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.adminportal_gamingshop.domain.Graphics_Card;
import com.adminportal_gamingshop.service.Graphics_Card_Service;

@Controller
@RequestMapping("/graphics_card")
public class Graphics_CardController {
	@Autowired
	private Graphics_Card_Service graphics_cardService;
	
	private String path = "D:/home/site/wwwroot/webapps/ROOT/images/graphics_card/";

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addgraphics_card(Model model) {
		Graphics_Card graphics_card = new Graphics_Card();
		model.addAttribute("graphics_card", graphics_card);
		return "addgraphics_card";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addgraphics_cardPost(@ModelAttribute("graphics_card") Graphics_Card graphics_card, HttpServletRequest request) {
		graphics_cardService.save(graphics_card);

		MultipartFile graphics_cardImage = graphics_card.getGraphicsImage();

		try {
			byte[] bytes = graphics_cardImage.getBytes();
			String name = graphics_card.getId() + ".jpg";
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File(path + name)));
			stream.write(bytes);
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:graphics_cardList";
	}
	
	@RequestMapping("/graphics_cardInfo")
	public String graphics_cardInfo(@RequestParam("id") Long id, Model model) {
		Graphics_Card graphics_card = graphics_cardService.findOne(id);
		model.addAttribute("graphics_card", graphics_card);
		
		return "graphics_cardInfo";
	}
	
	@RequestMapping("/updategraphics_card")
	public String updategraphics_card(@RequestParam("id") Long id, Model model) {
		Graphics_Card graphics_card = graphics_cardService.findOne(id);
		model.addAttribute("graphics_card", graphics_card);
		
		return "updategraphics_card";
	}
	
	@RequestMapping(value="/updategraphics_card", method=RequestMethod.POST)
	public String updategraphics_cardPost(@ModelAttribute("graphics_card") Graphics_Card graphics_card, HttpServletRequest request) {
		graphics_cardService.save(graphics_card);
		
		MultipartFile graphics_cardImage = graphics_card.getGraphicsImage();
		
		if(!graphics_cardImage.isEmpty()) {
			try {
				byte[] bytes = graphics_cardImage.getBytes();
				String name = graphics_card.getId() + ".jpg";
				
				Files.delete(Paths.get(path+name));
				
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File(path + name)));
				stream.write(bytes);
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return "redirect:/graphics_card/graphics_cardInfo?id="+graphics_card.getId();
	}
	
	@RequestMapping("/graphics_cardList")
	public String graphics_cardList(Model model) {
		List<Graphics_Card> graphics_cardList = graphics_cardService.findAll();
		model.addAttribute("graphics_cardList", graphics_cardList);		
		return "graphics_cardList";
		
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(
			@ModelAttribute("id") String id, Model model
			) {
		long pom = Long.parseLong(id.substring(17));
		graphics_cardService.removeOne(pom);
		String name = pom + ".jpg";	
		try
		{
			Files.delete(Paths.get(path+name));
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		List<Graphics_Card> graphics_cardList = graphics_cardService.findAll();
		model.addAttribute("graphics_cardList", graphics_cardList);
		
		return "redirect:/graphics_card/graphics_cardList";
	}
	

}
