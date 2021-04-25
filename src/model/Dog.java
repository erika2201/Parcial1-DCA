package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import processing.core.PApplet;

public class Dog {

	private PApplet app;
	private int id, age;
	private String name, breed;
	private Date birth; //I´m not sure with this
	private String date;
	
	
	public Dog(PApplet app, int id, String nombre, int edad, String raza, Date nacimiento) {
		this.app=app;
		this.id=id;
		this.name=name;
		this.age=age;
		this.breed=breed;
		this.birth=birth;
		
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		date = formato.format(birth);
	}
	
	public void drawInfo(int x, int y) {

		app.text("Id:" + id, x, y);
		app.text("Nombre:" + name, x, y + 20);
		app.text("Edad:" + age, x, y + 40);
		app.text("Raza:" + breed, x, y + 60);
		app.text("Fecha de Nacimiento:" + date, x, y + 80); //Line 25

	}
}
