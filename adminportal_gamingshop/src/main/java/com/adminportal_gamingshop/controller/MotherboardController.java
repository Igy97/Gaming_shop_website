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

import com.adminportal_gamingshop.domain.Motherboard;
import com.adminportal_gamingshop.service.MotherboarService;

@Controller
@RequestMapping("/motherboard")
public class MotherboardController {
	@Autowired
	private MotherboarService motherboardService;

	private String path = "D:/home/site/wwwroot/webapps/ROOT/images/motherboard/";
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addmotherboard(Model model) {
		Motherboard motherboard = new Motherboard();
		model.addAttribute("motherboard", motherboard);
		return "addmotherboard";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addmotherboardPost(@ModelAttribute("motherboard") Motherboard motherboard, HttpServletRequest request) {
		motherboardService.save(motherboard);

		MultipartFile motherboardImage = motherboard.getLaptopImage();

		try {
			byte[] bytes = motherboardImage.getBytes();
			String name = motherboard.getId() + ".jpg";
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File(path + name)));
			stream.write(bytes);
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:motherboardList";
	}
	
	@RequestMapping("/motherboardInfo")
	public String motherboardInfo(@RequestParam("id") Long id, Model model) {
		Motherboard motherboard = motherboardService.findOne(id);
		model.addAttribute("motherboard", motherboard);
		
		return "motherboardInfo";
	}
	
	@RequestMapping("/updatemotherboard")
	public String updatemotherboard(@RequestParam("id") Long id, Model model) {
		Motherboard motherboard = motherboardService.findOne(id);
		model.addAttribute("motherboard", motherboard);
		
		return "updatemotherboard";
	}
	
	@RequestMapping(value="/updatemotherboard", method=RequestMethod.POST)
	public String updatemotherboardPost(@ModelAttribute("motherboard") Motherboard motherboard, HttpServletRequest request) {
		motherboardService.save(motherboard);
		
		MultipartFile motherboardImage = motherboard.getLaptopImage();
		
		if(!motherboardImage.isEmpty()) {
			try {
				byte[] bytes = motherboardImage.getBytes();
				String name = motherboard.getId() + ".jpg";
				
				Files.delete(Paths.get(path+name));
				
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File(path + name)));
				stream.write(bytes);
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return "redirect:/motherboard/motherboardInfo?id="+motherboard.getId();
	}
	
	@RequestMapping("/motherboardList")
	public String motherboardList(Model model) {
		List<Motherboard> motherboardList = motherboardService.findAll();
		model.addAttribute("motherboardList", motherboardList);		
		return "motherboardList";
		
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(
			@ModelAttribute("id") String id, Model model
			) {
		long pom = Long.parseLong(id.substring(15));
		motherboardService.removeOne(pom);
		String name = pom + ".jpg";	
		try
		{
			Files.delete(Paths.get(path+name));
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		List<Motherboard> motherboardList = motherboardService.findAll();
		model.addAttribute("motherboardList", motherboardList);
		
		return "redirect:/motherboard/motherboardList";
	}
	

}
