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

}
