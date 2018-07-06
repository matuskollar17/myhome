package sk.mk.myhome.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sk.mk.myhome.entity.Boards;
import sk.mk.myhome.service.impl.ControllerService;
import sk.mk.myhome.service.impl.ControllerServiceJPA;
import sk.mk.myhome.service.impl.UserService;

@Controller
public class PinController {
	
	private Boards boards;
	
	public Boards getBoards() {
		return boards;
	}

	public void setBoards(Boards boards) {
		this.boards = boards;
	}

	@Autowired
	private UserService userServiceJPA;
	
	public ControllerService getControllerServiceJPA() {
		return controllerServiceJPA;
	}

	public void setControllerServiceJPA(ControllerService controllerServiceJPA) {
		this.controllerServiceJPA = controllerServiceJPA;
	}

	@Autowired
	private ControllerService controllerServiceJPA;
	
	@RequestMapping("/add_board")
	public String addBoard(Boards boards, Model model) throws IOException, SQLException {
					
			/*if (!userServiceJPA.isPlayer(controllerUsers.getLogin())) {*/
				controllerServiceJPA.register(boards);
				//loggedUser = userServiceJPA.login(controllerUsers.getLogin(), controllerUsers.getPassword());
			/*} else {
				errormsg = "Login already exists!!";
			}*/
		
		
		return "admin";
	}	
	
	
	@RequestMapping("/register_board")
	public String register_board(Boards boards, Model model) throws IOException, SQLException {
					
			/*if (!userServiceJPA.isPlayer(controllerUsers.getLogin())) {*/
				controllerServiceJPA.register(boards);
				//loggedUser = userServiceJPA.login(controllerUsers.getLogin(), controllerUsers.getPassword());
			/*} else {
				errormsg = "Login already exists!!";
			}*/
		
		
		return "admin";
	}
	
	
	private void fillModel(Model model) {
		model.addAttribute("controller", this);
		model.addAttribute("ControllerUsers", userServiceJPA.getControllerUsers());
		model.addAttribute("Boards", controllerServiceJPA.getBoard());
	}

}
