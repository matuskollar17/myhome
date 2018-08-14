package sk.mk.myhome.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Boards {
	
	@Id
	public String label;
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public int getNumOfPins() {
		return numOfPins;
	}
	public void setNumOfPins(int numOfPins) {
		this.numOfPins = numOfPins;
	}
	public int numOfPins;
	
	public Boards() {
		
	}
	
	public Boards(String label, int numOfPins) {
		this.label = label;
		this.numOfPins = numOfPins;
		
	}
	


}
