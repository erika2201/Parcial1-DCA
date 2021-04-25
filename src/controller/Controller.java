package controller;

import java.util.LinkedList;

import model.Dog;
import model.Logic;
import processing.core.PApplet;

public class Controller {

	private Logic logic;
	private PApplet app;

	public Controller (PApplet app) {
		this.app = app;
		logic= new Logic(app);
	}
	
	public void sortList(char c) {
		logic.sortList(c);
	}
	
	public LinkedList<Dog> getDogList() {
		return logic.getDogList();
	}
}
