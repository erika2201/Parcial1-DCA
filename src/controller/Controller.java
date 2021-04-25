package controller;

import model.Logic;
import processing.core.PApplet;

public class Controller {

	private Logic logic;
	private PApplet app;

	public Controller (PApplet app) {
		this.app = app;
		logic= new Logic(app);
	}
}
