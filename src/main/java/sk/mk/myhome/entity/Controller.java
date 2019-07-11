package sk.mk.myhome.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Controller {
	
	@Id
	public int ident;
	public String category;
	public int pin;
	public int state;
	public int poweron;
	public int poweroff;
	public String label; 
	
	
	
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public int getState(int pin) {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getPoweron() {
		return poweron;
	}
	public void setPoweron(int poweron) {
		this.poweron = poweron;
	}
	public int getPoweroff() {
		return poweroff;
	}
	public void setPoweroff(int poweroff) {
		this.poweroff = poweroff;
	}

	
	public int getIdent() {
		return ident;
	}
	public void setId(int ident) {
		this.ident = ident;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getState() {
		return state;
	}
	
}
