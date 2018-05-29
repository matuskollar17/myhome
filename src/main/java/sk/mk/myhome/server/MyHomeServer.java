package sk.mk.myhome.server;

import org.springframework.boot.SpringApplication;


import java.sql.SQLException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import sk.mk.myhome.controller.MyHomeController;

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
	
	
/*	@Bean
	public UserController userController() {
		return new UserController();
	}*/
	
	
	
}
