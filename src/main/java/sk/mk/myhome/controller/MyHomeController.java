package sk.mk.myhome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sk.mk.myhome.service.impl.ControllerService;
import sk.mk.myhome.service.impl.UserService;

@Controller
public class MyHomeController {
	
	@Autowired
	private UserService userServiceJPA;
	
	@Autowired
	private ControllerService controllerServiceJPA;
	
	@Autowired
	private PinController pinController;
	
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

	@RequestMapping("/admin")
	public String admin(Model model) {
		//fillModel(model);
		return "admin";
	}
	
	@RequestMapping("/home")
	public String home(Model model) {
		fillModel(model);
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
	
	
/*	@RequestMapping("/board_select")
	public String board_select(Model model) {
		fillModel(model);
		return "home";
	}*/
	
	private void fillModel(Model model) {
		model.addAttribute("controller", this);
		model.addAttribute("ControllerUsers", userServiceJPA.getControllerUsers());
		model.addAttribute("Boards", controllerServiceJPA.getBoard());
		model.addAttribute("pinController", pinController);
		
	}	
}
