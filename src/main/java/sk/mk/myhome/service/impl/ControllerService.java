package sk.mk.myhome.service.impl;

import sk.mk.myhome.entity.Boards;
import sk.mk.myhome.entity.Controller;

public interface ControllerService {

	void addBoard(Controller board);

	void register(Boards boards);

	Object getBoard();
	
	Object getBoardLabel();
	
	String getBoardInfo(String label);
	
	Controller getState();

	Controller getTableRows(String label);
	
}