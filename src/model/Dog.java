package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import processing.core.PApplet;

public class Dog {

	private PApplet app;
	private int id, age;
	private String name, breed;
	private Date birth; // I´m not sure with this
	private String date;

	public Dog(PApplet app, int id, String name, String breed, int age) {
		this.app = app;
		this.id = id;
		this.name = name;
		this.age = age;
		this.breed = breed;
		this.birth = birth;
	}

	public void drawInfo(int x) {

		app.text("ID:" + id, x, 100);
		app.text("Nombre:" + name, x, 120);
		app.text("Edad:" + age, x, 142);
		app.text("Raza:" + breed, x, 162);

		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String date = format.format(this.birth);
		app.text("B: " + date, x, 182);
	}

	
	public int compareTo(Dog nextDog) {
		return this.id - nextDog.getId();
	}

	//Getters
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}

	public String getBreed() {
		return breed;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setRace(String breed) {
		this.breed = breed;
	}

	public Date getDate() {
		return birth;
	}

	
	//Setters
	public void setAge(int age) {
		this.age = age;
	}

	public void setID(int iD) {
		id = iD;
	}

	public void setDate(Date birth) {
		this.birth = birth;
	}
}
