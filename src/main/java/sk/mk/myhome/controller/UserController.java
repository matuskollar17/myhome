package sk.mk.myhome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sk.mk.myhome.entity.ControllerUsers;
import sk.mk.myhome.service.impl.UserService;

@Controller
public class UserController {

		private ControllerUsers loggedUser;
		private String errormsg;
		
		@Autowired
		private UserService userServiceJPA;
		
		@RequestMapping("/login")
		public String login(ControllerUsers controllerUsers, Model model) {
			loggedUser = userServiceJPA.login(controllerUsers.getLogin(), controllerUsers.getPassword());
			//loginMsg = "";
		/*	if (loggedUser == null) {
				//loginMsg = "Username or password wrong";
			} else if (loggedPlayer.getRights() == -1) {
				loginMsg = "your account is banned, contact administrator";
				loggedPlayer = null;
			}*/
			errormsg = "";
			fillModel(model);
			//return "redirect:/";
			return "nav";
		}
		
		@RequestMapping("/logout")
		public String login(Model model) {
			loggedUser = null;
			//admin = false;
			return "redirect:/";
		}
		
		private void fillModel(Model model) {
			model.addAttribute("controller", this);
			model.addAttribute("ControllerUsers", userServiceJPA.getControllerUsers());
		//	model.addAttribute("ForumUser", userServiceJPA.getForumUser());
		}
		
		public boolean isLogged() {
			return loggedUser != null;
		}
		
		public ControllerUsers getLoggedUser() {
			return loggedUser;
		}

		public void setLoggedPlayer(ControllerUsers loggedUser) {
			this.loggedUser = loggedUser;
		}
}
