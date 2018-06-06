package sk.mk.myhome.service.impl;

import sk.mk.myhome.entity.ControllerUsers;

public interface UserService {

	void register(ControllerUsers user);

	ControllerUsers login(String login, String password);

}