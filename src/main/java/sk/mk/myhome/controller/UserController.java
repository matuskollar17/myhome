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
		public boolean isAdmin() {
			return admin;
		}

		public void setAdmin(boolean admin) {
			this.admin = admin;
		}

		public String getErrormsg() {
			return errormsg;
		}

		public void setErrormsg(String errormsg) {
			this.errormsg = errormsg;
		}

		private boolean admin;
		private String errormsg;
		
		public String getErrorMsg() {
			return errorMsg;
		}

		public void setErrorMsg(String errorMsg) {
			this.errorMsg = errorMsg;
		}

		public String getLoginMsg() {
			return loginMsg;
		}

		public void setLoginMsg(String loginMsg) {
			this.loginMsg = loginMsg;
		}

		public void setLoggedUser(ControllerUsers loggedUser) {
			this.loggedUser = loggedUser;
		}

		private String errorMsg;
		private String loginMsg;
		
		@Autowired
		private UserService userServiceJPA;
		
		@RequestMapping("/login")
		public String login(ControllerUsers controllerUsers, Model model) {
			loggedUser = userServiceJPA.login(controllerUsers.getLogin(), controllerUsers.getPassword());
			//loginMsg = "";
			if (loggedUser == null) {
				errorMsg = "Check your username or pass";
				return "index";
				//loginMsg = "Username or password wrong";
			} else if (loggedUser.getRights() == -1) {
				loginMsg = "your account is banned, contact administrator";
				loggedUser = null;
			}
			errorMsg = "";
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
