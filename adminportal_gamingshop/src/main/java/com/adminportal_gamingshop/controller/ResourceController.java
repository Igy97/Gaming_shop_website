package com.adminportal_gamingshop.controller;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adminportal_gamingshop.service.GameService;
import com.adminportal_gamingshop.service.Graphics_Card_Service;
import com.adminportal_gamingshop.service.LaptopService;
import com.adminportal_gamingshop.service.MotherboarService;
import com.adminportal_gamingshop.service.Pc_Case_Service;
import com.adminportal_gamingshop.service.ProcessorService;

@RestController
public class ResourceController {

	private String path = "D:/home/site/wwwroot/webapps/ROOT/images/";
	
	@Autowired
	private LaptopService laptopservice;
	
	@Autowired
	private ProcessorService processorService;
	
	@Autowired
	private MotherboarService motherboardService;
	
	@Autowired
	private Graphics_Card_Service graphics_cardService;
	
	@Autowired
	private Pc_Case_Service pc_caseService;
	
	@Autowired
	private GameService gameService;
	
	
	  @RequestMapping(value="/laptop/removeList", method=RequestMethod.POST) 
	  public String removeList(
	  
	  @RequestBody ArrayList<String> laptopIdList, Model model ){
	  
	  for (String id : laptopIdList) { String laptopId =id.substring(8);
	  laptopservice.removeOne(Long.parseLong(laptopId)); 
	  String name = laptopId + ".jpg";	
		try
		{
			Files.delete(Paths.get(path + "/laptop/"+ name));
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	  
	  }
	  
	  return "delete success"; }
	  
	  
	  @RequestMapping(value="/processor/removeList", method=RequestMethod.POST) 
	  public String removeList2(
	  
	  @RequestBody ArrayList<String> processorIdList, Model model ){
	  
	  for (String id : processorIdList) 
	  { 
	   String processorpId =id.substring(8);
	   String name = processorpId + ".jpg";	
		try
		{
			Files.delete(Paths.get(path + "/processor/"+ name));
		}
		catch (Exception e)
		{
			System.out.println(e);
		}	  
	  processorService.removeOne(Long.parseLong(processorpId));}  
	  return "delete success"; }
	  
	  @RequestMapping(value="/motherboard/removeList", method=RequestMethod.POST) 
	  public String removeList3(
	  
	  @RequestBody ArrayList<String> motherboardIdList, Model model ){
	  
	  for (String id : motherboardIdList) { String motherboardId =id.substring(8);
	  String name = motherboardId + ".jpg";	
		try
		{
			Files.delete(Paths.get(path + "/motherboard/"+ name));
		}
		catch (Exception e)
		{
			System.out.println(e);
		}	 
	  
	  motherboardService.removeOne(Long.parseLong(motherboardId));}
	   
	  return "delete success"; }
	  
	  @RequestMapping(value="/graphics_card/removeList", method=RequestMethod.POST) 
	  public String removeList4(
	  
	  @RequestBody ArrayList<String> graphicsIdList, Model model ){
	  
	  for (String id : graphicsIdList) { String graphicspId =id.substring(8);
	   String name = graphicspId + ".jpg";	
		try
		{
			Files.delete(Paths.get(path + "/graphics_card/"+ name));
		}
		catch (Exception e)
		{
			System.out.println(e);
		}	
	  
	  graphics_cardService.removeOne(Long.parseLong(graphicspId));}
	   
	  return "delete success"; }
	  
	  
	  @RequestMapping(value="/pc_case/removeList", method=RequestMethod.POST) 
	  public String removeList5(
	  
	  @RequestBody ArrayList<String> Pc_caseIdList, Model model ){
	  
	  for (String id : Pc_caseIdList) { String pc_casepId =id.substring(8);
	  String name = pc_casepId  + ".jpg";	
		try
		{
			Files.delete(Paths.get(path + "/pc_case/"+ name));
		}
		catch (Exception e)
		{
			System.out.println(e);
		}	
	  
	  pc_caseService.removeOne(Long.parseLong(pc_casepId));}
	   
	  return "delete success"; }
	  
	  @RequestMapping(value="/game/removeList", method=RequestMethod.POST) 
	  public String removeList6(
	  
	  @RequestBody ArrayList<String> GAMEIdList, Model model ){
	  
	  for (String id :  GAMEIdList) { String gamepId =id.substring(8);
	  String name = gamepId + ".jpg";	
		try
		{
			Files.delete(Paths.get(path + "/game/"+ name));
		}
		catch (Exception e)
		{
			System.out.println(e);
		}	  
	  
	  gameService.removeOne(Long.parseLong(gamepId));}
	   
	  return "delete success"; }
	  
}
	  
	  
	  
	  
	 


	  
