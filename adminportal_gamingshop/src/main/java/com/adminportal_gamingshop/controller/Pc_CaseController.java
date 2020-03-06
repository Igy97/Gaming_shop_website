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

import com.adminportal_gamingshop.domain.Pc_Case;
import com.adminportal_gamingshop.service.Pc_Case_Service;

@Controller
@RequestMapping("/pc_case")
public class Pc_CaseController {
	@Autowired
	private Pc_Case_Service pc_caseService;
	
	private String path = "D:/home/site/wwwroot/webapps/ROOT/images/pc_case/";
	/* private String path = "src/main/resources/static/image/pc_case/"; */

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addpc_case(Model model) {
		Pc_Case pc_case = new Pc_Case();
		model.addAttribute("pc_case", pc_case);
		return "addpc_case";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addpc_casePost(@ModelAttribute("pc_case") Pc_Case pc_case, HttpServletRequest request) {
		pc_caseService.save(pc_case);

		MultipartFile pc_caseImage = pc_case.getLaptopImage();

		try {
			byte[] bytes = pc_caseImage.getBytes();
			String name = pc_case.getId() + ".jpg";
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File(path + name)));
			stream.write(bytes);
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:pc_caseList";
	}
	
	@RequestMapping("/pc_caseInfo")
	public String pc_caseInfo(@RequestParam("id") Long id, Model model) {
		Pc_Case pc_case = pc_caseService.findOne(id);
		model.addAttribute("pc_case", pc_case);
		
		return "pc_caseInfo";
	}
	
	@RequestMapping("/updatepc_case")
	public String updatepc_case(@RequestParam("id") Long id, Model model) {
		Pc_Case pc_case = pc_caseService.findOne(id);
		model.addAttribute("pc_case", pc_case);
		
		return "updatepc_case";
	}
	
	@RequestMapping(value="/updatepc_case", method=RequestMethod.POST)
	public String updatepc_casePost(@ModelAttribute("pc_case") Pc_Case pc_case, HttpServletRequest request) {
		pc_caseService.save(pc_case);
		
		MultipartFile pc_caseImage = pc_case.getLaptopImage();
		
		if(!pc_caseImage.isEmpty()) {
			try {
				byte[] bytes = pc_caseImage.getBytes();
				String name = pc_case.getId() + ".jpg";
				
				Files.delete(Paths.get(path + name));
				
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File(path + name)));
				stream.write(bytes);
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return "redirect:/pc_case/pc_caseInfo?id="+pc_case.getId();
	}
	
	@RequestMapping("/pc_caseList")
	public String pc_caseList(Model model) {
		List<Pc_Case> pc_caseList = pc_caseService.findAll();
		model.addAttribute("pc_caseList", pc_caseList);		
		return "pc_caseList";
		
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(
			@ModelAttribute("id") String id, Model model
			) {
		long pom = Long.parseLong(id.substring(11));
		pc_caseService.removeOne(pom);
		String name = pom + ".jpg";	
		try
		{
			Files.delete(Paths.get(path+name));
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		List<Pc_Case> pc_caseList = pc_caseService.findAll();
		model.addAttribute("pc_caseList", pc_caseList);
		
		return "redirect:/pc_case/pc_caseList";
	}
	

}
