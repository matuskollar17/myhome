package sk.mk.myhome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyHomeController {
	
	@RequestMapping("/")
	public String user(Model model) {
		//fillModel(model);
		return "index";
	}
	
	@RequestMapping("/nav")
	public String nav(Model model) {
		//fillModel(model);
		return "nav";
	}
	
	@RequestMapping("/profile")
	public String profile(Model model) {
		//fillModel(model);
		return "profile";
	}

	@RequestMapping("/admini")
	public String admin(Model model) {
		//fillModel(model);
		return "admin";
	}
	
	@RequestMapping("/home")
	public String home(Model model) {
		//fillModel(model);
		return "home";
	}
	
	@RequestMapping("/garage")
	public String garage(Model model) {
		//fillModel(model);
		return "garage";
	}
	
	@RequestMapping("/garden")
	public String garden(Model model) {
		//fillModel(model);
		return "garden";
	}
}
