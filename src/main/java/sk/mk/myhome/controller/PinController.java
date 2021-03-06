package sk.mk.myhome.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch.qos.logback.core.net.SyslogOutputStream;
import sk.mk.myhome.entity.Boards;
import sk.mk.myhome.entity.ControllerUsers;
import sk.mk.myhome.service.impl.ControllerService;
import sk.mk.myhome.service.impl.ControllerServiceJPA;
import sk.mk.myhome.service.impl.UserService;

@Controller
public class PinController {
	
	private Boards boards;
	
	private Controller controller;
	
	public Boards getBoards() {
		return boards;
	}
	
	public String testVariable;
		
	public int rowTest = getTableRows();

	public void setBoards(Boards boards) {
		this.boards = boards;
	}
	
	private int tableRows;

	public int getTableRows() {
		return tableRows;
	}

	public void setTableRows(int tableRows) {
		this.tableRows = tableRows;
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
	
	
	@RequestMapping("/add_board_category")
	public String addBoard(Controller controller, Model model) throws IOException, SQLException {
					
			/*if (!userServiceJPA.isPlayer(controllerUsers.getLogin())) {*/
				controllerServiceJPA.register(boards);
				//loggedUser = userServiceJPA.login(controllerUsers.getLogin(), controllerUsers.getPassword());
			/*} else {
				errormsg = "Login already exists!!";
			}*/
		
		
		return "admin";
	}
	
	
	
	
	@RequestMapping("/board_select")
	public String boardSelect(@RequestParam(value = "board_select", required = false) String value, Boards boards, Model model ) throws IOException, SQLException {
					
			//if (value == 8) {}
				//int foo = Integer.parseInt(value);
		//setTableRows(foo);
		System.err.println(value);
		//int skusam = controllerServiceJPA.getBoardInfo(value);
		//int hodnota = controllerServiceJPA.getBoardInfo(value);
		int foo = Integer.parseInt(controllerServiceJPA.getBoardInfo(value));
		
		System.err.println(foo);
		//for (int i = 0; i < controllerServiceJPA.getBoardInfo(value); i++) {
			
		//};
		
		
	//	controllerServiceJPA.getBoardInfo(value);
		//System.err.println(skusam);
	//	controllerServiceJPA.getBoard(get);
		//System.err.println(controllerServiceJPA.getBoardInfo(value));
		//testVariable = value;
		fillModel(model);
		
//		
		return "forward:/home";
	}	
	
	
	private void fillModel(Model model) {
		model.addAttribute("pinController", this);
		model.addAttribute("ControllerUsers", userServiceJPA.getControllerUsers());
		model.addAttribute("Boards", controllerServiceJPA.getBoard());
		model.addAttribute("Boards", controllerServiceJPA.getBoardLabel());
		//model.addAttribute("Boards", controllerServiceJPA.getBoardInfo(testVariable));
		//model.addAttribute("GetTableRows", controllerServiceJPA.getTableRows(tableRows));
	}
	
		public void valueTest() {
		System.out.println(rowTest);
		}
	
	public String render() {
		
		
		StringBuilder sb = new StringBuilder();
		sb.append("<p>");
		sb.append("je tu toten gadzo");
		sb.append(testVariable);
		sb.append(testVariable);
	//	sb.append(controllerServiceJPA.getBoardInfo(testVariable));
		sb.append("</p>");
		sb.append("<table class=''>\n");

		sb.append("<tr>\n");
		
				sb.append("<th>\n");
		
					sb.append("<p>Label</p>\n");
		
				sb.append("</th>\n");

		
				sb.append("<th>\n");
		
					sb.append("<p>Pin</p>\n");
		
				sb.append("</th>\n");
		
				sb.append("<th>\n");
		
					sb.append("<p>On</p>\n");
		
				sb.append("</th>\n");
		
				sb.append("<th>\n");
		
					sb.append("<p>Off</p>\n");
		
				sb.append("</th>\n");
		
				sb.append("<th>\n");
		
					sb.append("<p>State</p>\n");
		
				sb.append("</th>\n");
		
				sb.append("<th>\n");
		
					sb.append("<p>Scheduler</p>\n");
		
				sb.append("</th>\n");
		
				sb.append("</tr>\n");
		
		/* table head si completed, loop will create requested number of lines with buttons*/
		
		//for (int i = 0; i < getTableRows(); i++) {
				for (int i = 0; i < 8; i++) {
			sb.append("<tr>\n");	
			/*System.err.println(getTableRows());*/
			
			////need to get number of active pins.
			//System.err.println(controllerServiceJPA.);
			sb.append("<td>\n");
			
			//sb.append("Controller.getLabel\n");
			
			/*sb.append(controllerServiceJPA.getState());*/
			sb.append(testVariable);
			
			sb.append("</td>\n");
			
			//sb.append("<td>\n");
						
			sb.append("<td>\n");
			
			sb.append("<p>input type</p>\n");
			
			sb.append("</td>\n");
			
			sb.append("<td>\n");
			
			sb.append("<img src='img/page/power-button-on.png' class='pwrbtn'/>\n");
			
			sb.append("</td>\n");
			
			sb.append("<td>\n");
			
			sb.append("<img src='img/page/power-button-off.png' class='pwrbtn'/>\n");
			
			sb.append("</td>\n");
			
			sb.append("<td>\n");
			if ( 1 == 1) {
			sb.append("<img src='img/page/bulb-on.png' class='bulb'/>\n");
			} else {
			
				sb.append("<img src='img/page/bulb-off.png' class='bulb'/>\n");
			}
				
			sb.append("</td>\n");
			
			sb.append("<td>\n");
			
			sb.append("<a href='#'>Scheduler</a>\n");
			
			sb.append("</td>\n");
			
			sb.append("</tr>\n");
		}
		
		
		
		
	/*	sb.append("<td>\n");
		sb.append("<p>test2</p>\n");
		sb.append("</td>\n");
		sb.append("<td>\n");
		sb.append("<p>test3</p>\n");
		sb.append("</td>\n");*/
		
		// sb.append(String.format("<a href='/mines?row=%d&column=%d'>\n", row,
		// column));
	//	sb.append("<img src ='/images/mines/" + image + ".png'>\n");
		// sb.append("</a>\n");
		//sb.append("</td>\n");
	//} else {
		//sb.append("<td>\n");
		// sb.append("<a href='/mines'>\n");
		//sb.append(String.format("<a href='/mines3?row=%d&column=%d'>\n", row, column));
	//	sb.append("<img src ='/images/mines/" + image + ".png'>\n");
	//	sb.append("</a>\n");
		//sb.append("</td>\n");
	//}


		//sb.append("</tr>\n");
		
		sb.append("</table>\n");

		
	
	return sb.toString();
	
	}
		
		
		
}

	
/*	public Boards getBoards() {
		return boards;
	}*/
	

