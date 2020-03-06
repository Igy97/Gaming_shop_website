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

import com.adminportal_gamingshop.domain.Game;
import com.adminportal_gamingshop.service.GameService;

@Controller
@RequestMapping("/game")
public class GameController {
	@Autowired
	private GameService gameService;

	private String path = "D:/home/site/wwwroot/webapps/ROOT/images/game/";
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addgame(Model model) {
		Game game = new Game();
		model.addAttribute("game", game);
		return "addgame";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addgamePost(@ModelAttribute("game") Game game, HttpServletRequest request) {
		gameService.save(game);

		MultipartFile gameImage = game.getGameImage();

		try {
			byte[] bytes = gameImage.getBytes();
			String name = game.getId() + ".jpg";
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File(path + name)));
			stream.write(bytes);
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:gameList";
	}
	
	@RequestMapping("/gameInfo")
	public String gameInfo(@RequestParam("id") Long id, Model model) {
		Game game = gameService.findOne(id);
		model.addAttribute("game", game);
		
		return "gameInfo";
	}
	
	@RequestMapping("/updategame")
	public String updategame(@RequestParam("id") Long id, Model model) {
		Game game = gameService.findOne(id);
		model.addAttribute("game", game);
		
		return "updategame";
	}
	
	@RequestMapping(value="/updategame", method=RequestMethod.POST)
	public String updategamePost(@ModelAttribute("game") Game game, HttpServletRequest request) {
		gameService.save(game);
		
		MultipartFile gameImage = game.getGameImage();
		
		if(!gameImage.isEmpty()) {
			try {
				byte[] bytes = gameImage.getBytes();
				String name = game.getId() + ".jpg";
				
				Files.delete(Paths.get(path+name));
				
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File(path + name)));
				stream.write(bytes);
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return "redirect:/game/gameInfo?id="+game.getId();
	}
	
	@RequestMapping("/gameList")
	public String gameList(Model model) {
		List<Game> gameList = gameService.findAll();
		model.addAttribute("gameList", gameList);		
		return "gameList";
		
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(
			@ModelAttribute("id") String id, Model model
			) {
		long pom = Long.parseLong(id.substring(8));
		gameService.removeOne(pom);
		String name = pom + ".jpg";	
		try
		{
			Files.delete(Paths.get(path+name));
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		List<Game> gameList = gameService.findAll();
		model.addAttribute("gameList", gameList);
		
		return "redirect:/game/gameList";
	}
	

}
