package sk.mk.myhome.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import sk.mk.myhome.controller.MyHomeController;
import sk.mk.myhome.controller.PinController;
import sk.mk.myhome.controller.UserController;
import sk.mk.myhome.service.impl.ControllerService;
import sk.mk.myhome.service.impl.ControllerServiceJPA;
import sk.mk.myhome.service.impl.UserService;
import sk.mk.myhome.service.impl.UserServiceJPA;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan({ "sk.mk.myhome.entity" })
public class MyHomeServer {

	public static void main(String[] args) {
		SpringApplication.run(MyHomeServer.class, args);

	}

	@Bean
	public MyHomeController myHomeController() {
		return new MyHomeController();
	}
	
	
	@Bean
	public UserController userController() {
		return new UserController();
	}
	
	@Bean
	public PinController pincontroller() {
		return new PinController();
	}
	
	@Bean
	public UserService userService() {
		return new UserServiceJPA();
	}
	
	@Bean
	public ControllerService controllerService() {
		return new ControllerServiceJPA();
	}
	
	
	
}
