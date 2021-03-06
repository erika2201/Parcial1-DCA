package view;
import controller.Controller;
import processing.core.PApplet;
import processing.core.PFont;

public class Main extends PApplet{

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());
		
	}
	
	@Override
	public void settings() {
		size(1500,500);
	}
	
	Controller controller;
	PFont myFont;
	
	@Override
	public void setup() {
		myFont = createFont("Poppins-Regular.ttf", 18);
		controller= new Controller(this);
	}
	
	
	@Override
	public void draw() {
		background(88, 24, 69 );
		drawInstructions();
		
		for (int i = 0; i < controller.getDogList().size(); i++) {
			controller.getDogList().get(i).drawInfo(150+(185*i),300);
		}
	}

	private void drawInstructions() {
		
		textFont(myFont);
		fill(255, 195, 0);
		text("FUNDACIÓN PELUDITOS SIN HOGAR", 25, 50);	
		
		fill(255, 195, 150);
		text("Para organizar por cada cateforia, presione las tecla correspondiente:", 25, 90);
		text("I = ID", 50, 120);
		text("N = Nombre", 50, 140);
		text("E = Edad", 50, 160);
		text("R = Raza", 50, 180);
		text("F = Fecha de Nacimiento", 50, 200);
	}
	
	public void keyPressed() {
		controller.sortList(key);
	}
}