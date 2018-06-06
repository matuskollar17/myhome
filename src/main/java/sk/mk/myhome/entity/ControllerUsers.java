package sk.mk.myhome.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class ControllerUsers {
	
	@Id
	@GeneratedValue
	private int ident;

	@Column(unique = true)
	public String login;
	public String password;
	
	public int getIdent() {
		return ident;
	}
	public void setIdent(int ident) {
		this.ident = ident;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public ControllerUsers() {
	}
	
	
	public ControllerUsers(String login, String password) {
		this.login = login;
		this.password = password;
	
	}
	

}
