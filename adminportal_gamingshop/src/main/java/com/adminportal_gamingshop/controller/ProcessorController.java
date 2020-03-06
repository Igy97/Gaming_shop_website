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

import com.adminportal_gamingshop.domain.Processor;
import com.adminportal_gamingshop.service.ProcessorService;

@Controller
@RequestMapping("/processor")
public class ProcessorController {
	@Autowired
	private ProcessorService processorService;
	
	private String path = "D:/home/site/wwwroot/webapps/ROOT/images/processor/";

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addprocessor(Model model) {
		Processor processor = new Processor();
		model.addAttribute("processor", processor);
		return "addprocessor";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addprocessorPost(@ModelAttribute("processor") Processor processor, HttpServletRequest request) {
		processorService.save(processor);

		MultipartFile processorImage = processor.getProcessorImage();

		try {
			byte[] bytes = processorImage.getBytes();
			String name = processor.getId() + ".jpg";
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File(path  + name)));
			stream.write(bytes);
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:processorList";
	}
	
	@RequestMapping("/processorInfo")
	public String processorInfo(@RequestParam("id") Long id, Model model) {
		Processor processor = processorService.findOne(id);
		model.addAttribute("processor", processor);
		
		return "processorInfo";
	}
	
	@RequestMapping("/updateprocessor")
	public String updateprocessor(@RequestParam("id") Long id, Model model) {
		Processor processor = processorService.findOne(id);
		model.addAttribute("processor", processor);
		
		return "updateprocessor";
	}
	
	@RequestMapping(value="/updateprocessor", method=RequestMethod.POST)
	public String updateprocessorPost(@ModelAttribute("processor") Processor processor, HttpServletRequest request) {
		processorService.save(processor);
		
		MultipartFile processorImage = processor.getProcessorImage();
		
		if(!processorImage.isEmpty()) {
			try {
				byte[] bytes = processorImage.getBytes();
				String name = processor.getId() + ".jpg";
				
				Files.delete(Paths.get(path +name));
				
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File(path  + name)));
				stream.write(bytes);
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return "redirect:/processor/processorInfo?id="+processor.getId();
	}
	
	@RequestMapping("/processorList")
	public String processorList(Model model) {
		List<Processor> processorList = processorService.findAll();
		model.addAttribute("processorList", processorList);		
		return "processorList";
		
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(
			@ModelAttribute("id") String id, Model model
			) {
		long pom = Long.parseLong(id.substring(13));
		processorService.removeOne(pom);
		String name = pom + ".jpg";	
		try
		{
			Files.delete(Paths.get(path +name));
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		List<Processor> processorList = processorService.findAll();
		model.addAttribute("processorList", processorList);
		
		return "redirect:/processor/processorList";
	}
	

}
