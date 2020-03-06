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

import com.adminportal_gamingshop.domain.Laptop;
import com.adminportal_gamingshop.service.LaptopService;

@Controller
@RequestMapping("/laptop")
public class LaptopController {
	
	private String path = "D:/home/site/wwwroot/webapps/ROOT/images/laptop/";
	
	@Autowired
	private LaptopService laptopService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addlaptop(Model model) {
		Laptop laptop = new Laptop();
		model.addAttribute("laptop", laptop);
		return "addlaptop";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addlaptopPost(@ModelAttribute("laptop") Laptop laptop, HttpServletRequest request) {
		laptopService.save(laptop);

		MultipartFile laptopImage = laptop.getLaptopImage();

		try {
			byte[] bytes = laptopImage.getBytes();
			String name = laptop.getId() + ".jpg";
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File( path + name)));
			stream.write(bytes);
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:laptopList";
	}
	
	@RequestMapping("/laptopInfo")
	public String laptopInfo(@RequestParam("id") Long id, Model model) {
		Laptop laptop = laptopService.findOne(id);
		model.addAttribute("laptop", laptop);
		
		return "laptopInfo";
	}
	
	@RequestMapping("/updatelaptop")
	public String updatelaptop(@RequestParam("id") Long id, Model model) {
		Laptop laptop = laptopService.findOne(id);
		model.addAttribute("laptop", laptop);
		
		return "updateLaptop";
	}
	
	@RequestMapping(value="/updatelaptop", method=RequestMethod.POST)
	public String updatelaptopPost(@ModelAttribute("laptop") Laptop laptop, HttpServletRequest request) {
		laptopService.save(laptop);
		
		MultipartFile laptopImage = laptop.getLaptopImage();
		
		if(!laptopImage.isEmpty()) {
			try {
				byte[] bytes = laptopImage.getBytes();
				String name = laptop.getId() + ".jpg";
				
				Files.delete(Paths.get(path +name));
				
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File(path + name)));
				stream.write(bytes);
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return "redirect:/laptop/laptopInfo?id="+laptop.getId();
	}
	
	@RequestMapping("/laptopList")
	public String laptopList(Model model) {
		List<Laptop> laptopList = laptopService.findAll();
		model.addAttribute("laptopList", laptopList);		
		return "laptopList";
		
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(
			@ModelAttribute("id") String id, Model model
			) {
		long pom = Long.parseLong(id.substring(10));
		laptopService.removeOne(pom);
		String name = pom + ".jpg";	
		try
		{
			Files.delete(Paths.get(path + name));
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		List<Laptop> laptopList = laptopService.findAll();
		model.addAttribute("laptopList", laptopList);
		
		return "redirect:/laptop/laptopList";
	}
	

}
