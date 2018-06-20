package sk.mk.myhome.service.impl;

import sk.mk.myhome.entity.Boards;
import sk.mk.myhome.entity.Controller;

public interface ControllerService {

	void addBoard(Controller board);

	void register(Boards boards);

}